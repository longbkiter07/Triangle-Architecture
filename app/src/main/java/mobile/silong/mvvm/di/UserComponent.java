package mobile.silong.mvvm.di;

import dagger.Component;
import mobile.silong.mvvm.view.listuser.ListUserActivity;
import mobile.silong.mvvm.view.singleuser.SingleUserActivity;

/**
 * Created by lamtn on 4/15/16.
 */
@PerActivity
@Component(dependencies = AppComponent.class, modules = {UserModule.class})
public interface UserComponent {

  void inject(ListUserActivity listUserActivity);

  void inject(SingleUserActivity singleUserActivity);
}
