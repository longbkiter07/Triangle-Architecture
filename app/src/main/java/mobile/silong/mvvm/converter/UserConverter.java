package mobile.silong.mvvm.converter;

import mobile.silong.mvvm.data.local.converter.MVVMConverter;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.model.AppUser;

/**
 * Created by lamtn on 4/14/16.
 */
public class UserConverter implements MVVMConverter<User, AppUser> {
  @Override
  public AppUser convert(User user) {
    return user instanceof AppUser
            ? (AppUser) user
            : new AppUser(user.getId(), user.getFullName(), user.getEmail(),
            user.getDescription(), user.getFollowers(), user.getCoverUrl());
  }
}
