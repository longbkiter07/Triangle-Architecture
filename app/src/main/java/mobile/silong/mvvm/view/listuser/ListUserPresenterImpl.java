package mobile.silong.mvvm.view.listuser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import mobile.silong.mvvm.converter.UserConverter;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.subscriber.DefaultSubscriber;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.model.AppUser;
import mobile.silong.mvvm.transformer.BackgroundTaskTransformer;
import mobile.silong.mvvm.viewmodel.UserViewModel;

/**
 * Created by lamtn on 4/13/16.
 */
public class ListUserPresenterImpl implements ListUserPresenter {

  private ListUserView mListUserView;
  private List<UserViewModel> mUserViewModels;

  @Inject
  ListUserUseCase mListUserUseCase;

  public ListUserPresenterImpl(ListUserView listUserView, List<UserViewModel> userViewModels, ListUserUseCase listUserUseCase) {
    mListUserView = listUserView;
    mUserViewModels = userViewModels;
    mListUserUseCase = listUserUseCase;
  }

  @Override
  public void attachView(ListUserView listUserView) {
    mListUserView = listUserView;
  }

  @Override
  public void detachView() {
    mListUserView = null;
  }

  public void getListUser() {
    mListUserUseCase.buildUseCase()
            .compose(new BackgroundTaskTransformer<>())
            .subscribe(new UserListSubscriber());
  }

  private final class UserListSubscriber extends DefaultSubscriber<List<User>> {
    @Override
    public void onCompleted() {
      mListUserView.hideLoading();
    }

    @Override
    public void onError(Throwable e) {
      mListUserView.hideLoading();
      mListUserView.showError(e.getMessage());
      mListUserView.showRetry();
    }

    @Override
    public void onNext(List<User> users) {
      UserConverter converter = new UserConverter();
      List<AppUser> appUsers = new ArrayList<>(users.size());
      for (User user : users) {
        appUsers.add(converter.convert(user));
      }
      mListUserView.renderListUser(appUsers);
    }
  }
}