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

package mobile.silong.mvvm;

import com.facebook.drawee.backends.pipeline.Fresco;

import android.app.Application;

import mobile.silong.mvvm.data.DataApp;
import mobile.silong.mvvm.di.AppComponent;
import mobile.silong.mvvm.di.AppModule;
import mobile.silong.mvvm.di.DaggerAppComponent;

/**
 * Created by SILONG on 4/13/16.
 */
public class App extends Application {

  private AppComponent mAppComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    DataApp.init(this);
    Fresco.initialize(this);
  }

  public AppComponent getApplicationComponent() {
    if (mAppComponent == null) {
      mAppComponent = DaggerAppComponent.builder()
          .appModule(new AppModule(this))
          .build();
    }
    return mAppComponent;
  }
}
