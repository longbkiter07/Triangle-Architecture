package mobile.silong.mvvm.data.local.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import mobile.silong.mvvm.data.local.MVVMDatabase;
import mobile.silong.mvvm.domain.model.User;

/**
 * Created by SILONG on 4/13/16.
 */
@Table(database = MVVMDatabase.class)
public class CacheUser extends BaseModel implements User {

  @PrimaryKey String id;

  @Column String fullName;

  @Column String email;

  @Column String description;

  @Column String followers;

  @Column String coverUrl;

  public CacheUser() {
  }

  public CacheUser(String id, String fullName, String email, String description, String followers, String coverUrl) {
    this.id = id;
    this.fullName = fullName;
    this.email = email;
    this.description = description;
    this.followers = followers;
    this.coverUrl = coverUrl;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getFullName() {
    return fullName;
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
    return coverUrl;
  }
}
