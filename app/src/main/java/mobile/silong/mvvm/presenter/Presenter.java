package mobile.silong.mvvm.presenter;

/**
 * Created by lamtn on 4/13/16.
 */
public interface Presenter<V> {

  void attachView(V view);

  void detachView();
}
