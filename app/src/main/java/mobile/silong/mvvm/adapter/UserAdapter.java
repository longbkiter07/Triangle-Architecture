package mobile.silong.mvvm.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mobile.silong.mvvm.R;
import mobile.silong.mvvm.databinding.ItemUserBinding;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.presentation.ItemUserViewModel;

/**
 * Created by lamtn on 4/13/16.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserBindingHolder> {

  private Context mContext;
  private List<User> mUserList;

  public UserAdapter(Context mContext) {
    this.mContext = mContext;
    this.mUserList = new ArrayList<>();
  }

  @Override
  public UserBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ItemUserBinding userBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext),
            R.layout.item_user,
            parent,
            false
    );

    return new UserBindingHolder(userBinding);
  }

  @Override
  public void onBindViewHolder(UserBindingHolder holder, int position) {
    holder.binding.setItemUser(new ItemUserViewModel(mContext, this.mUserList.get(position)));
  }

  public void setUserList(List<User> userList) {
    this.mUserList = userList;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mUserList != null ? mUserList.size() : 0;
  }

  public class UserBindingHolder extends RecyclerView.ViewHolder {

    ItemUserBinding binding;

    public UserBindingHolder(ItemUserBinding binding) {
      super(binding.cardView);
      this.binding = binding;
    }
  }
}
