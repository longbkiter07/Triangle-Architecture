package mobile.silong.mvvm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

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
  }

  @Override
  protected void onDestroy() {
    mViewModel.detachView();
    super.onDestroy();
  }

  public abstract void bindViewModel(T viewModel);

  public abstract T createViewModel();

}
