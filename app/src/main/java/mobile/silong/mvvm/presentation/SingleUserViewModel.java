package mobile.silong.mvvm.presentation;

import com.kennyc.view.MultiStateView;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.view.singleuser.SingleUserView;

/**
 * Created by lamtn on 4/14/16.
 */
public class SingleUserViewModel extends BaseViewModel<SingleUserView> {

  private static final String TAG = SingleUserViewModel.class.getSimpleName();

  private String mUserId;

  private SingleUserUseCase mSingleUserUseCase;

  public ObservableField<String> id = new ObservableField<>();

  public ObservableField<String> fullName = new ObservableField<>();

  public ObservableField<String> email = new ObservableField<>();

  public ObservableField<String> description = new ObservableField<>();

  public ObservableField<String> followers = new ObservableField<>();

  public ObservableField<String> coverUrl = new ObservableField<>();

  public ObservableInt state = new ObservableInt();

  @Inject
  public SingleUserViewModel(SingleUserUseCase singleUserUseCase) {
    mSingleUserUseCase = singleUserUseCase;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    load();
  }

  private void load() {
    state.set(MultiStateView.VIEW_STATE_LOADING);

    mSingleUserUseCase
        .with(mUserId)
        .buildUseCase()
        .compose(new BackgroundTaskTransformer<>())
        .subscribe(user -> {
          Log.i(TAG, "onNext");
          state.set(MultiStateView.VIEW_STATE_CONTENT);
          setUser(user);
        }, throwable -> {
          Log.e(TAG, "onError: " + throwable.getMessage());
          state.set(MultiStateView.VIEW_STATE_ERROR);
        });
  }

  public void setUserId(String userId) {
    mUserId = userId;
  }

  public void setUser(User user) {
    id.set(user.getId());
    fullName.set(user.getFullName());
    email.set(user.getEmail());
    description.set(user.getDescription());
    followers.set(user.getFollowers());
    coverUrl.set(user.getCoverUrl());
  }
}
