package mobile.silong.mvvm.presentation;

import android.os.Bundle;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.subscriber.DefaultSubscriber;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.view.listuser.ListUserView;

/**
 * Created by lamtn on 4/14/16.
 */
public class ListUserViewModel extends BaseViewModel<ListUserView> {

  private List<User> mUserList;

  private ListUserUseCase mListUserUseCase;

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
        .subscribe(new ListUserSubscriber());
  }

  public List<User> getUserList() {
    return mUserList;
  }

  private final class ListUserSubscriber extends DefaultSubscriber<List<User>> {

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(List<User> users) {
      mUserList = users;
    }
  }
}