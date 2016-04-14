package mobile.silong.mvvm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mobile.silong.mvvm.model.AppUser;

/**
 * Created by lamtn on 4/13/16.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserBindingHolder> {

  private Context mContext;
  private List<AppUser> mUserList;

  public UserAdapter(Context mContext) {
    this.mContext = mContext;
    this.mUserList = new ArrayList<>();
  }

  @Override
  public UserBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//    ItemUserBinding userBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(mContext),
//            R.layout.item_user,
//            parent,
//            false
//    );
//
//    return new UserBindingHolder(userBinding);
    return null;
  }

  @Override
  public void onBindViewHolder(UserBindingHolder holder, int position) {
//    holder.binding.setUserViewModel(new UserViewModel(mContext, this.mUserList.get(position)));
  }

  public void setUserList(List<AppUser> userList) {
    this.mUserList = userList;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return this.mUserList.size();
  }

  public class UserBindingHolder extends RecyclerView.ViewHolder {
    public UserBindingHolder(View itemView) {
      super(itemView);
    }

//    ItemUserBinding binding;

  }
}
