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

  private static App sInstance;

  @Override
  public void onCreate() {
    super.onCreate();
    sInstance = this;
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

  public static App getInstance() {
    return sInstance;
  }
}
