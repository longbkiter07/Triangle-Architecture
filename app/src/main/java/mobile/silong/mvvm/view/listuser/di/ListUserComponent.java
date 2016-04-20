package mobile.silong.mvvm.view.listuser.di;

import dagger.Subcomponent;
import mobile.silong.mvvm.di.PerActivity;
import mobile.silong.mvvm.presentation.ListUserViewModel;

/**
 * Created by SILONG on 4/20/16.
 */
@Subcomponent(modules = ListUserModule.class)
@PerActivity
public interface ListUserComponent {

  ListUserViewModel getListUserViewModel();
}
