package mobile.silong.mvvm.domain.usecase;

import android.text.TextUtils;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.ApiService;
import mobile.silong.mvvm.domain.service.LocalService;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public class SingleUserUseCase implements UseCase<User> {

  private final ApiService mApiService;

  private final LocalService mLocalService;

  private String mId;

  public SingleUserUseCase(ApiService apiService, LocalService localService) {
    mApiService = apiService;
    mLocalService = localService;
  }

  public SingleUserUseCase with(String id) {
    mId = id;
    return this;
  }

  @Override
  public Observable<User> buildUseCase() {
    if (TextUtils.isEmpty(mId)) {
      return Observable.error(new IllegalArgumentException());
    } else {
      return mApiService.getUser(mId)
          .ofType(User.class)
          .flatMap(user -> mLocalService.saveUser(user).flatMap(aVoid -> Observable.just(user)));
    }
  }
}
