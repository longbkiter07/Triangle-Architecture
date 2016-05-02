/*
 * Copyright(c) 2016 "Si Long <long.bkiter07@gmail.com>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package me.silong.mvvm.data.local;

import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.runtime.transaction.process.SaveModelTransaction;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import me.silong.mvvm.data.local.model.CacheUser;
import me.silong.mvvm.data.local.model.CacheUser_Table;
import me.silong.mvvm.domain.converter.MVVMConverter;
import me.silong.mvvm.domain.exception.DataNotFoundException;
import me.silong.mvvm.domain.model.User;
import me.silong.mvvm.domain.service.LocalService;
import me.silong.mvvm.domain.util.RxUtils;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by SILONG on 4/13/16.
 */
public class DatabaseService implements LocalService {

  private static final String TAG = DatabaseService.class.getSimpleName();

  private final MVVMConverter<User, CacheUser> mUserConverter;

  private PublishSubject<User> mSubject;

  public DatabaseService(MVVMConverter<User, CacheUser> userConverter) {
    mUserConverter = userConverter;
    mSubject = PublishSubject.create();
  }

  @Override
  public Observable<User> observeLocalChange() {
    return mSubject;
  }

  @Override
  public Observable<User> getUser(String id) {

    return Observable.create((Observable.OnSubscribe<User>) subscriber -> {
      try {
        User user = SQLite.select().from(CacheUser.class).where(CacheUser_Table.id.eq(id)).querySingle();
        if (user == null) {
          RxUtils.onError(subscriber, new DataNotFoundException());
        } else {
          RxUtils.onNext(subscriber, user, true);
        }
      } catch (Exception e) {
        RxUtils.onError(subscriber, e);
      }
    });
  }

  @Override
  public Observable<List<? extends User>> getUsers() {

    return Observable.create(subscriber -> {
      try {
        List<CacheUser> cacheUsers = SQLite.select().from(CacheUser.class).queryList();
        RxUtils.onNext(subscriber, cacheUsers, true);
      } catch (Exception e) {
        RxUtils.onError(subscriber, e);
      }
    });
  }

  @Override
  public Observable<Void> saveUser(User user) {

    return Observable.create(subscriber -> {
      try {
        CacheUser cacheUser = mUserConverter.convert(user);
        cacheUser.save();
        mSubject.onNext(user);
        RxUtils.onNext(subscriber, null, true);
      } catch (Exception e) {
        RxUtils.onError(subscriber, e);
      }
    });
  }

  @Override
  public Observable<Void> saveUsers(List<User> users) {

    return Observable.create(subscriber -> {
      try {
        List<CacheUser> cacheUsers = new ArrayList<CacheUser>(users.size());
        for (User user : users) {
          cacheUsers.add(mUserConverter.convert(user));
          mSubject.onNext(user);
        }
        new SaveModelTransaction(ProcessModelInfo.withModels(cacheUsers)).onExecute();
        RxUtils.onNext(subscriber, null, true);
      } catch (Exception e) {
        RxUtils.onError(subscriber, e);
      }
    });
  }

  @Override
  public Observable<Void> removeUser(String id) {
    return Observable.create(subscriber -> {
      try {
        SQLite.delete().from(CacheUser.class).where(CacheUser_Table.id.eq(id)).execute();
        RxUtils.onNext(subscriber, null, true);
      } catch (Exception e) {
        RxUtils.onError(subscriber, e);
      }
    });
  }

  @Override
  public Observable<Void> removeUsers(List<String> ids) {
    return Observable.create(subscriber -> {
      try {
        SQLite.delete().from(CacheUser.class).where(CacheUser_Table.id.in(ids)).execute();
        RxUtils.onNext(subscriber, null, true);
      } catch (Exception e) {
        RxUtils.onError(subscriber, e);
      }
    });
  }
}
