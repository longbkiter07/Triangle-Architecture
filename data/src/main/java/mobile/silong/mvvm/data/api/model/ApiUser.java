package mobile.silong.mvvm.data.api.model;

import mobile.silong.mvvm.domain.model.User;

/**
 * Created by SILONG on 4/13/16.
 */
public class ApiUser implements User {

  String id;

  String cover_url;

  String description;

  String followers;

  String email;

  String full_name;

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getFullName() {
    return full_name;
  }

  @Override
  public String getEmail() {
    return email;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public String getFollowers() {
    return followers;
  }

  @Override
  public String getCoverUrl() {
    return cover_url;
  }
}
