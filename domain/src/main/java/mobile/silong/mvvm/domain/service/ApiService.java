package mobile.silong.mvvm.domain.service;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public interface ApiService {

  <T extends User> Observable<List<T>> getUsers();

  Observable<? extends User> getUser(String id);

}
