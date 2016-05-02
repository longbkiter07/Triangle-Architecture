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

package me.silong.mvvm.data.local.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import me.silong.mvvm.data.local.MVVMDatabase;
import me.silong.mvvm.domain.model.User;

/**
 * Created by SILONG on 4/13/16.
 */
@Table(database = MVVMDatabase.class)
public class CacheUser extends BaseModel implements User {

  @PrimaryKey String id;

  @Column String fullName;

  @Column String email;

  @Column String description;

  @Column String followers;

  @Column String coverUrl;

  public CacheUser() {
  }

  public CacheUser(String id, String fullName, String email, String description, String followers, String coverUrl) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.description = description;
    this.followers = followers;
    this.coverUrl = coverUrl;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getFullName() {
    return fullName;
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
    return coverUrl;
  }
}
