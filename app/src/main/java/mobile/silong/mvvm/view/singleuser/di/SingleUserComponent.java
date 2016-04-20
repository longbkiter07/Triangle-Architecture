package mobile.silong.mvvm.view.singleuser.di;

import dagger.Subcomponent;
import mobile.silong.mvvm.di.PerActivity;
import mobile.silong.mvvm.presentation.SingleUserViewModel;

/**
 * Created by SILONG on 4/20/16.
 */
@Subcomponent(modules = SingleUserModule.class)
@PerActivity
public interface SingleUserComponent {

  SingleUserViewModel getSingleUserViewModel();
}
