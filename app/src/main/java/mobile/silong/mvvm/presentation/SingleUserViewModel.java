package mobile.silong.mvvm.presentation;

import android.databinding.Bindable;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import mobile.silong.mvvm.BR;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.view.singleuser.SingleUserView;

/**
 * Created by lamtn on 4/14/16.
 */
public class SingleUserViewModel extends BaseViewModel<SingleUserView> {

  private static final String TAG = SingleUserViewModel.class.getSimpleName();

  private User mUser;

  private String mUserId;

  private SingleUserUseCase mSingleUserUseCase;

  @Inject
  public SingleUserViewModel(SingleUserUseCase singleUserUseCase) {
    mSingleUserUseCase = singleUserUseCase;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    load();
  }

  private void load() {
    mSingleUserUseCase.with(mUserId).buildUseCase()
        .compose(new BackgroundTaskTransformer<>())
        .subscribe(user -> {
          Log.i(TAG, "onNext");
          mUser = user;
          notifyPropertyChanged(BR.user);
        }, throwable -> {
          Log.e(TAG, "onError: " + throwable.getMessage());
        });
  }

  public void setUserId(String userId) {
    mUserId = userId;
  }

  @Bindable
  public User getUser() {
    return mUser;
  }

  public void setUser(User user) {
    mUser = user;
  }
}
