package mobile.silong.mvvm.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.model.AppUser;

/**
 * Created by lamtn on 4/14/16.
 */
public class UserViewModel extends BaseObservable implements User {

  private Context mContext;
  private AppUser mAppUser;

  public UserViewModel(Context context, AppUser appUser) {
    mContext = context;
    mAppUser = appUser;
  }

  @Override
  public String getId() {
    return this.mAppUser.getId();
  }

  @Override
  public String getFullName() {
    return this.mAppUser.getFullName();
  }

  @Override
  public String getEmail() {
    return this.mAppUser.getEmail();
  }

  @Override
  public String getDescription() {
    return this.mAppUser.getDescription();
  }

  @Override
  public String getFollowers() {
    return this.mAppUser.getFollowers();
  }

  @Override
  public String getCoverUrl() {
    return this.mAppUser.getCoverUrl();
  }
}
