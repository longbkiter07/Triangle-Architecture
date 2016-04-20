package mobile.silong.mvvm.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.data.di.DataModule;
import mobile.silong.mvvm.domain.di.DomainModule;

/**
 * Created by SILONG on 4/13/16.
 */
@Module(includes = {DataModule.class, DomainModule.class})
public class AppModule {

  private Application mApp;

  public AppModule(Application app) {
    mApp = app;
  }

  @Provides
  @Singleton
  @AppContext
  public Context provideAppContext() {
    return mApp;
  }

  @Provides
  @Singleton
  public Resources provideResource(@AppContext Context context) {
    return context.getResources();
  }

}
