package mobile.silong.mvvm.view.listuser;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.view.MVVMView;

/**
 * Created by lamtn on 4/13/16.
 */
public interface ListUserView extends MVVMView {

  void renderListUser(List<User> users);

  void viewUser(User user);
}
