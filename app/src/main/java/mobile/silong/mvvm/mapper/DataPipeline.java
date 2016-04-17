package mobile.silong.mvvm.mapper;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.presentation.SingleUserViewModel;

/**
 * Created by lamtn on 4/15/16.
 */
public class DataPipeline {

  public static void mapping(SingleUserViewModel singleUserViewModel, User user) {
    if (singleUserViewModel != null && user != null) {
      singleUserViewModel.setUser(user);
    }
  }
}
