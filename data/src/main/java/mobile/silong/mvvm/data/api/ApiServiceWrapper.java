package mobile.silong.mvvm.data.api;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.ApiService;
import rx.Observable;

/**
 * Created by SILONG on 4/14/16.
 */
public class ApiServiceWrapper implements ApiService {

  private HttpApiService mHttpApiService;

  public ApiServiceWrapper(HttpApiService httpApiService) {
    mHttpApiService = httpApiService;
  }

  @Override
  public Observable<List<? extends User>> getUsers() {
    return mHttpApiService.getUsers().flatMap(apiUsers -> Observable.just(apiUsers));
  }

  @Override
  public Observable<User> getUser(String id) {
    return mHttpApiService.getUser(id).ofType(User.class);
  }
}