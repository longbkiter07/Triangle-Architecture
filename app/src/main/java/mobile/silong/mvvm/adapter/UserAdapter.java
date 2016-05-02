/*
 * Copyright(c) 2016 "Si Long <long.bkiter07@gmail.com>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
      super(binding.getRoot());
      this.binding = binding;
    }
  }
}
