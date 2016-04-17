package mobile.silong.mvvm.presentation;

import android.databinding.Bindable;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import mobile.silong.mvvm.BR;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.view.listuser.ListUserView;

/**
 * Created by lamtn on 4/14/16.
 */
public class ListUserViewModel extends BaseViewModel<ListUserView> {

  private static final String TAG = ListUserViewModel.class.getSimpleName();

  private List<User> mUserList;

  private ListUserUseCase mListUserUseCase;

  @Inject
  public ListUserViewModel(ListUserUseCase listUserUseCase) {
    mListUserUseCase = listUserUseCase;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    load();
  }

  public void load() {
    mListUserUseCase.buildUseCase()
        .compose(new BackgroundTaskTransformer<>())
        .subscribe(users -> {
          Log.i(TAG, "load");
          mUserList = users;
          notifyPropertyChanged(BR.userList);
        }, throwable -> {
          Log.e(TAG, "load: " + throwable.getMessage());
        });
  }

  @Bindable
  public List<User> getUserList() {
    return mUserList;
  }
}
