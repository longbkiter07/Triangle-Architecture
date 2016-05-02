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

package mobile.silong.mvvm.domain.usecase;

import android.text.TextUtils;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.LocalService;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public class SingleUserUseCase implements UseCase<User> {

  private static final String TAG = SingleUserUseCase.class.getSimpleName();

  private final LocalService mLocalService;

  private final GetAndSaveUserUseCase mGetAndSaveUserUseCase;

  private String mId;

  public SingleUserUseCase(LocalService localService, GetAndSaveUserUseCase getAndSaveUserUseCase) {
    mLocalService = localService;
    mGetAndSaveUserUseCase = getAndSaveUserUseCase;
  }

  public SingleUserUseCase with(String id) {
    mId = id;
    return this;
  }

  @Override
  public Observable<User> buildUseCase() {
    if (TextUtils.isEmpty(mId)) {
      return Observable.error(new IllegalArgumentException());
    } else {
      return mLocalService
          .getUser(mId)
          .onErrorResumeNext(throwable -> mGetAndSaveUserUseCase.with(mId).buildUseCase());
    }
  }
}
