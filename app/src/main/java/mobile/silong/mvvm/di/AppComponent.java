package mobile.silong.mvvm.di;

import javax.inject.Singleton;

import dagger.Component;
import mobile.silong.mvvm.presentation.ListUserViewModel;
import mobile.silong.mvvm.presentation.SingleUserViewModel;

/**
 * Created by SILONG on 4/13/16.
 */
@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {

   ListUserViewModel getListUserViewModel();

   SingleUserViewModel getSingleUserViewModel();
}
