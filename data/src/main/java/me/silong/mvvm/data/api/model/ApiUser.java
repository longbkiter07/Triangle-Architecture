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

package me.silong.mvvm.data.api.model;

import me.silong.mvvm.domain.model.User;

/**
 * Created by SILONG on 4/13/16.
 */
public class ApiUser implements User {

  String id;

  String cover_url;

  String description;

  String followers;

  String email;

  String full_name;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getFullName() {
    return full_name;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getFollowers() {
    return followers;
  }

  @Override
  public String getCoverUrl() {
    return cover_url;
  }
}
