package mobile.silong.mvvm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import mobile.silong.mvvm.App;
import mobile.silong.mvvm.di.AppComponent;
import mobile.silong.mvvm.presentation.BaseViewModel;

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

  @Override
  public void showShortToast(String message) {

  }
}
