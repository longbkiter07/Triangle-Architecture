package mobile.silong.mvvm.view.singleuser;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.view.MVVMView;

/**
 * Created by lamtn on 4/14/16.
 */
public interface SingleUserView extends MVVMView {

  void renderUser(User user);
}
