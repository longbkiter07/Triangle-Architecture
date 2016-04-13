package mobile.silong.mvvm.domain.usecase;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.ApiService;
import mobile.silong.mvvm.domain.service.LocalService;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public class ListUserUseCase implements UseCase<List<User>> {

  private ApiService mApiService;

  private LocalService mLocalService;

  public ListUserUseCase(ApiService apiService, LocalService localService) {
    mApiService = apiService;
    mLocalService = localService;
  }

  @Override
  public Observable<List<User>> buildUseCase() {
    return mApiService.getUsers()
        .flatMap(users -> mLocalService
            .saveUsers(users)
            .flatMap(aVoid -> Observable.just(users)));
  }
}
