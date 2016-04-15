package mobile.silong.mvvm.presentation;

import android.os.Bundle;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.view.singleuser.SingleUserView;
import rx.Subscriber;

/**
 * Created by lamtn on 4/14/16.
 */
public class SingleUserViewModel extends BaseViewModel<SingleUserView> implements User {

  private User mUser;

  private SingleUserUseCase mSingleUserUseCase;

  public SingleUserViewModel(SingleUserUseCase singleUserUseCase) {
    mSingleUserUseCase = singleUserUseCase;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    load();
  }

  private void load() {
    mSingleUserUseCase.buildUseCase()
        .compose(new BackgroundTaskTransformer<>())
        .subscribe(new SingleUserSubscriber());
  }

  public User getUser() {
    return mUser;
  }

  @Override
  public String getId() {
    return this.mUser.getId();
  }

  @Override
  public String getFullName() {
    return this.mUser.getFullName();
  }

  @Override
  public String getEmail() {
    return this.mUser.getEmail();
  }

  @Override
  public String getDescription() {
    return this.mUser.getDescription();
  }

  @Override
  public String getFollowers() {
    return this.mUser.getFollowers();
  }

  @Override
  public String getCoverUrl() {
    return this.mUser.getCoverUrl();
  }

  private final class SingleUserSubscriber extends Subscriber<User> {

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(User user) {
      mUser = user;
    }
  }
}
