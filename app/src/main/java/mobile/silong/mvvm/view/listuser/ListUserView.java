package mobile.silong.mvvm.view.listuser;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.model.AppUser;
import mobile.silong.mvvm.view.LoadDataView;

/**
 * Created by lamtn on 4/13/16.
 */
public interface ListUserView extends LoadDataView {

  void renderListUser(List<AppUser> users);

  void viewUser(User user);
}
