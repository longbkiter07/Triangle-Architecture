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

package me.silong.mvvm.domain.usecase;

import me.silong.mvvm.domain.model.User;
import me.silong.mvvm.domain.service.ApiService;
import me.silong.mvvm.domain.service.LocalService;
import rx.Observable;

/**
 * Created by lamtn on 4/19/16.
 */
public class GetAndSaveUserUseCase implements UseCase<User> {

  private final ApiService mApiService;

  private final LocalService mLocalService;

  private String mId;

  public GetAndSaveUserUseCase(ApiService apiService, LocalService localService) {
    mApiService = apiService;
    mLocalService = localService;
  }

  public GetAndSaveUserUseCase with(String id) {
    this.mId = id;
    return this;
  }

  @Override
  public Observable<User> buildUseCase() {
    return mApiService.getUser(mId)
        .flatMap(user -> mLocalService.saveUser(user)
            .flatMap(aVoid -> Observable.just((User) user))
        );
  }
}
