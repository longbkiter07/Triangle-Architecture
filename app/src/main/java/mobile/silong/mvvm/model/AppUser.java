package mobile.silong.mvvm.model;

import mobile.silong.mvvm.domain.model.User;

/**
 * Created by lamtn on 4/14/16.
 */
public class AppUser implements User {

  private String id;
  private String fullName;
  private String email;
  private String description;
  private String followers;
  private String coverUrl;

  public AppUser(String id, String fullName, String email, String description, String followers, String coverUrl) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.description = description;
    this.followers = followers;
    this.coverUrl = coverUrl;
  }

  @Override
  public String getId() {
    return null;
  }

  @Override
  public String getFullName() {
    return null;
  }

  @Override
  public String getEmail() {
    return null;
  }

  @Override
  public String getDescription() {
    return null;
  }

  @Override
  public String getFollowers() {
    return null;
  }

  @Override
  public String getCoverUrl() {
    return null;
  }
}
