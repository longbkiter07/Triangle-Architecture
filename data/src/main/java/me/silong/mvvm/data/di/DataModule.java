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

package me.silong.mvvm.data.di;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.silong.mvvm.data.api.ApiServiceImpl;
import me.silong.mvvm.data.api.HttpApiService;
import me.silong.mvvm.data.local.DatabaseService;
import me.silong.mvvm.data.local.converter.CacheUserConverter;
import me.silong.mvvm.data.local.model.CacheUser;
import me.silong.mvvm.domain.converter.MVVMConverter;
import me.silong.mvvm.domain.model.User;
import me.silong.mvvm.domain.service.ApiService;
import me.silong.mvvm.domain.service.LocalService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SILONG on 4/13/16.
 */
@Module
public class DataModule {

  public DataModule() {

  }

  @Provides
  @Singleton
  public LocalService provideLocalService(MVVMConverter<User, CacheUser> converter) {
    return new DatabaseService(converter);
  }

  @Provides
  @Singleton
  public MVVMConverter<User, CacheUser> provideCacheUserConverter() {
    return new CacheUserConverter();
  }

  @Provides
  @Singleton
  public ApiService provideApiService(OkHttpClient okHttpClient, Gson gson) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://android-architecture.silong.me")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(okHttpClient)
        .build();
    return new ApiServiceImpl(retrofit.create(HttpApiService.class));
  }

  @Provides
  @Singleton
  public OkHttpClient provideOkHttp() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return new OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(35, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build();
  }

  @Provides
  @Singleton
  public Gson provideGson() {
    return new Gson();
  }


}
