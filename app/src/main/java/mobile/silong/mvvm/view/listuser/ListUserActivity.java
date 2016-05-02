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

package mobile.silong.mvvm.view.listuser;

import android.databinding.DataBindingUtil;

import mobile.silong.mvvm.R;
import mobile.silong.mvvm.databinding.ActivityListUserBinding;
import mobile.silong.mvvm.presentation.ListUserViewModel;
import mobile.silong.mvvm.view.BaseActivity;
import mobile.silong.mvvm.view.listuser.di.ListUserModule;

public class ListUserActivity extends BaseActivity<ListUserViewModel> implements ListUserView {

  @Override
  public void bindViewModel(ListUserViewModel viewModel) {
    ActivityListUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list_user);
    binding.setListUserViewModel(viewModel);
  }

  @Override
  public ListUserViewModel createViewModel() {
    return getAppComponent().plus(new ListUserModule()).getListUserViewModel();
  }

}
