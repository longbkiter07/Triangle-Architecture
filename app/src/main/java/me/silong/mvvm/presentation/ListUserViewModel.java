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

package me.silong.mvvm.presentation;

import com.kennyc.view.MultiStateView;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.util.Log;

import me.silong.mvvm.domain.model.User;
import me.silong.mvvm.domain.usecase.RemoteListUserUseCase;
import me.silong.mvvm.transformer.BackgroundTaskTransformer;
import me.silong.mvvm.view.listuser.ListUserView;

/**
 * Created by lamtn on 4/14/16.
 */
public class ListUserViewModel extends BaseViewModel<ListUserView> {

  private static final String TAG = ListUserViewModel.class.getSimpleName();

  private RemoteListUserUseCase mRemoteListUserUseCase;

  public ObservableArrayList<User> userList = new ObservableArrayList<>();

  public ObservableInt state = new ObservableInt();

  public ListUserViewModel(RemoteListUserUseCase remoteListUserUseCase) {
    mRemoteListUserUseCase = remoteListUserUseCase;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    loadAllUsers();
  }

  public void loadAllUsers() {
    state.set(MultiStateView.VIEW_STATE_LOADING);
    mRemoteListUserUseCase.buildUseCase()
        .compose(new BackgroundTaskTransformer<>())
        .subscribe(users -> {
          Log.i(TAG, "loadAllUsers");
          state.set(MultiStateView.VIEW_STATE_CONTENT);
          userList.clear();
          userList.addAll(users);
        }, throwable -> {
          Log.e(TAG, "loadAllUsers: " + throwable.getMessage());
          state.set(MultiStateView.VIEW_STATE_ERROR);
        });
  }
}
