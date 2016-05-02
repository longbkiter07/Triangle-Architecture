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

package me.silong.mvvm.view.singleuser;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import me.silong.mvvm.Constant;
import me.silong.mvvm.R;
import me.silong.mvvm.databinding.ActivitySingleUserBinding;
import me.silong.mvvm.presentation.SingleUserViewModel;
import me.silong.mvvm.view.BaseActivity;
import me.silong.mvvm.view.singleuser.di.SingleUserModule;

public class SingleUserActivity extends BaseActivity<SingleUserViewModel> {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
  }

  @Override
  public void bindViewModel(SingleUserViewModel viewModel) {
    ActivitySingleUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_single_user);
    binding.setUserModel(viewModel);
  }

  @Override
  public SingleUserViewModel createViewModel() {
    return getAppComponent()
        .plus(new SingleUserModule(getIntent().getExtras().getString(Constant.Extra.EXTRA_USER_ID)))
        .getSingleUserViewModel();
  }
}
