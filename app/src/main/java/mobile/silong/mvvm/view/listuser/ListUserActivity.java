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
