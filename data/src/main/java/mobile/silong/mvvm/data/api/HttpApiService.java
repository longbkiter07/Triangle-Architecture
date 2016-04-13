package mobile.silong.mvvm.data.api;

import java.util.List;

import mobile.silong.mvvm.data.api.model.ApiUser;
import mobile.silong.mvvm.domain.service.ApiService;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public interface HttpApiService extends ApiService {

  @GET("users.json")
  Observable<List<ApiUser>> getUsers();

  @GET("user_{id}.json")
  Observable<ApiUser> getUser(@Path("id") String id);
}
