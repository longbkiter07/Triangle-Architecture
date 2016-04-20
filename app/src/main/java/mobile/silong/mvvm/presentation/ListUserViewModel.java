package mobile.silong.mvvm.presentation;

import com.kennyc.view.MultiStateView;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.view.listuser.ListUserView;

/**
 * Created by lamtn on 4/14/16.
 */
public class ListUserViewModel extends BaseViewModel<ListUserView> {

  private static final String TAG = ListUserViewModel.class.getSimpleName();

  private ListUserUseCase mListUserUseCase;

  public ObservableArrayList<User> userList = new ObservableArrayList<>();

  public ObservableInt state = new ObservableInt();

  public ListUserViewModel(ListUserUseCase listUserUseCase) {
    mListUserUseCase = listUserUseCase;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    loadAllUsers();
  }

  public void loadAllUsers() {
    state.set(MultiStateView.VIEW_STATE_LOADING);
    mListUserUseCase.buildUseCase()
        .compose(new BackgroundTaskTransformer<>())
        .subscribe(users -> {
          Log.i(TAG, "loadAllUsers");
          state.set(MultiStateView.VIEW_STATE_CONTENT);
          userList.clear();
          userList.addAll(users);
        }, throwable -> {
          Log.e(TAG, "loadAllUsers: " + throwable.getMessage());
          state.set(MultiStateView.VIEW_STATE_ERROR);
        });
  }
}
