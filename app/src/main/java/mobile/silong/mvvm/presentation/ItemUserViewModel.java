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
