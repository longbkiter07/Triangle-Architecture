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

package me.silong.mvvm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import me.silong.mvvm.App;
import me.silong.mvvm.di.AppComponent;
import me.silong.mvvm.presentation.BaseViewModel;

/**
 * Created by SILONG on 4/13/16.
 */
public abstract class BaseActivity<T extends BaseViewModel> extends AppCompatActivity implements MVVMView {

  private T mViewModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewModel = createViewModel();
    mViewModel.attachView(this);
    bindViewModel(mViewModel);
    mViewModel.onCreate(savedInstanceState);
  }

  @Override
  protected void onResume() {
    mViewModel.onResume();
    super.onResume();
  }

  @Override
  protected void onPause() {
    mViewModel.onPause();
    super.onPause();
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  public AppComponent getAppComponent() {
    return ((App) getApplication()).getApplicationComponent();
  }

  @Override
  protected void onDestroy() {
    mViewModel.detachView();
    mViewModel.onDestroy();
    super.onDestroy();
  }

  public abstract void bindViewModel(T viewModel);

  public abstract T createViewModel();

}
