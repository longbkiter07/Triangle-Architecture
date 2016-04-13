package mobile.silong.mvvm.data.local.converter;

import mobile.silong.mvvm.data.local.model.CacheUser;
import mobile.silong.mvvm.domain.model.User;

/**
 * Created by SILONG on 4/13/16.
 */
public class CacheUserConverter implements MVVMConverter<User, CacheUser> {

  @Override
  public CacheUser convert(User from) {
    return from instanceof CacheUser
        ? (CacheUser) from
        : new CacheUser(from.getId(), from.getFullName(), from.getEmail(), from.getDescription(), from.getFollowers(), from.getCoverUrl());
  }
}
