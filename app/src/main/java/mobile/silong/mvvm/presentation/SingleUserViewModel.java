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

package mobile.silong.mvvm.presentation;

import com.kennyc.view.MultiStateView;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.util.Log;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.view.singleuser.SingleUserView;

/**
 * Created by lamtn on 4/14/16.
 */
public class SingleUserViewModel extends BaseViewModel<SingleUserView> {

  private static final String TAG = SingleUserViewModel.class.getSimpleName();

  public ObservableField<String> id = new ObservableField<>();

  public ObservableField<String> fullName = new ObservableField<>();

  public ObservableField<String> email = new ObservableField<>();

  public ObservableField<String> description = new ObservableField<>();

  public ObservableField<String> followers = new ObservableField<>();

  public ObservableField<String> coverUrl = new ObservableField<>();

  public ObservableInt state = new ObservableInt();

  private String mUserId;

  private SingleUserUseCase mSingleUserUseCase;

  public SingleUserViewModel(String userId, SingleUserUseCase singleUserUseCase) {
    mSingleUserUseCase = singleUserUseCase;
    mUserId = userId;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    loadUser();
  }

  private void loadUser() {
    state.set(MultiStateView.VIEW_STATE_LOADING);

    mSingleUserUseCase
        .with(mUserId)
        .buildUseCase()
        .compose(new BackgroundTaskTransformer<>())
        .subscribe(user -> {
          Log.i(TAG, "onNext");
          state.set(MultiStateView.VIEW_STATE_CONTENT);
          setUser(user);
        }, throwable -> {
          Log.e(TAG, "onError: " + throwable.getMessage());
          state.set(MultiStateView.VIEW_STATE_ERROR);
        });
  }

  public void setUser(User user) {
    id.set(user.getId());
    fullName.set(user.getFullName());
    email.set(user.getEmail());
    description.set(user.getDescription());
    followers.set(user.getFollowers());
    coverUrl.set(user.getCoverUrl());
  }
}
