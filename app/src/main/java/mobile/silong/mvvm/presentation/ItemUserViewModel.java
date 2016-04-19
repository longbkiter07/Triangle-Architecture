package mobile.silong.mvvm.presentation;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import mobile.silong.mvvm.Constant;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.view.singleuser.SingleUserActivity;

/**
 * Created by lamtn on 4/15/16.
 */
public class ItemUserViewModel extends BaseViewModel {

  private Context mContext;

  private User mUser;

  public ItemUserViewModel(Context context, User user) {
    mContext = context;
    mUser = user;
  }

  public String getFullName() {
    return this.mUser.getFullName();
  }

  public View.OnClickListener onClickItemUser() {
    return v -> {
      Intent intent = new Intent(mContext, SingleUserActivity.class);
      intent.putExtra(Constant.Extra.EXTRA_USER_ID, mUser.getId());
      mContext.startActivity(intent);
    };
  }
}
