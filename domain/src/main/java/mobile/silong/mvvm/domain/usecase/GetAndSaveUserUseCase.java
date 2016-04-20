package mobile.silong.mvvm.domain.usecase;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.ApiService;
import mobile.silong.mvvm.domain.service.LocalService;
import rx.Observable;

/**
 * Created by lamtn on 4/19/16.
 */
public class GetAndSaveUserUseCase implements UseCase<User> {

  private final ApiService mApiService;

  private final LocalService mLocalService;

  private String mId;

  public GetAndSaveUserUseCase(ApiService apiService, LocalService localService) {
    mApiService = apiService;
    mLocalService = localService;
  }

  public GetAndSaveUserUseCase with(String id) {
    this.mId = id;
    return this;
  }

  @Override
  public Observable<User> buildUseCase() {
    return mApiService.getUser(mId)
        .flatMap(user -> mLocalService.saveUser(user)
            .flatMap(aVoid -> Observable.just((User) user))
        );
  }
}
