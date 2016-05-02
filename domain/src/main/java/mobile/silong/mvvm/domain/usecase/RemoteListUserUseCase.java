package mobile.silong.mvvm.domain.usecase;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.ApiService;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public class RemoteListUserUseCase implements UseCase<List<? extends User>> {

  private ApiService mApiService;

  public RemoteListUserUseCase(ApiService apiService) {
    mApiService = apiService;
  }

  @Override
  public Observable<List<? extends User>> buildUseCase() {
    return mApiService.getUsers();
  }
}
