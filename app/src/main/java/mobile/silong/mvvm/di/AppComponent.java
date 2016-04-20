package mobile.silong.mvvm.di;

import javax.inject.Singleton;

import dagger.Component;
import mobile.silong.mvvm.view.listuser.di.ListUserComponent;
import mobile.silong.mvvm.view.listuser.di.ListUserModule;
import mobile.silong.mvvm.view.singleuser.di.SingleUserComponent;
import mobile.silong.mvvm.view.singleuser.di.SingleUserModule;

/**
 * Created by SILONG on 4/13/16.
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

  ListUserComponent plus(ListUserModule listUserModule);

  SingleUserComponent plus(SingleUserModule singleUserModule);
}
