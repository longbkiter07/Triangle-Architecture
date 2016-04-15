package mobile.silong.mvvm.domain.subscriber;

import rx.Subscriber;

/**
 * Created by lamtn on 4/13/16.
 */
public abstract class DefaultSubscriber<T> extends Subscriber<T> {
  @Override
  public void onCompleted() {

  }

  @Override
  public void onError(Throwable e) {

  }

  @Override
  public void onNext(T t) {

  }
}
