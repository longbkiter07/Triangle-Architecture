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

package me.silong.mvvm.domain.service;

import java.util.List;

import me.silong.mvvm.domain.model.User;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public interface LocalService {

  Observable<User> getUser(String id);

  Observable<List<? extends User>> getUsers();

  Observable<Void> saveUser(User user);

  Observable<Void> removeUser(String id);

  Observable<Void> saveUsers(List<User> users);

  Observable<Void> removeUsers(List<String> users);

  Observable<User> observeLocalChange();
}
