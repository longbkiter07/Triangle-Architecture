package mobile.silong.mvvm.domain.service;

import java.util.List;

import mobile.silong.mvvm.domain.model.User;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public interface LocalService {

  Observable<User> getUser(String id);

  Observable<List<? extends User>> getUsers();

  Observable<Void> saveUser(User user);

  Observable<Void> removeUser(String id);

  Observable<Void> saveUsers(List<User> users);

  Observable<Void> removeUsers(List<String> users);

  Observable<User> observeLocalChange();

}
