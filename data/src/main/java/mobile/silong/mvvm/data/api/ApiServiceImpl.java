package mobile.silong.mvvm.data.api;

import java.util.List;

import mobile.silong.mvvm.data.api.transformer.BaseApiTransformer;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.ApiService;
import rx.Observable;

/**
 * Created by SILONG on 4/14/16.
 */
public class ApiServiceImpl implements ApiService {

  private HttpApiService mHttpApiService;

  public ApiServiceImpl(HttpApiService httpApiService) {
    mHttpApiService = httpApiService;
  }

  @Override
  public Observable<List<? extends User>> getUsers() {
    return mHttpApiService.getUsers().compose(new BaseApiTransformer<>());
  }

  @Override
  public Observable<User> getUser(String id) {
    return mHttpApiService.getUser(id).compose(new BaseApiTransformer<>());
  }
}
