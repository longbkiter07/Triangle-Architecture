package mobile.silong.mvvm.domain.util;

import rx.Subscriber;

public class RxUtils {

  private RxUtils() {

  }

  public static <T> void onComplete(Subscriber<T> subscriber) {
    if (subscriber != null && !subscriber.isUnsubscribed()) {
      subscriber.onCompleted();
    }
  }

  public static <T> void onError(Subscriber<T> subscriber, Throwable e) {
    if (subscriber != null && !subscriber.isUnsubscribed()) {
      subscriber.onError(e);
    }
  }

  public static <T> void onNext(Subscriber<T> subscriber, T data, boolean isComplete) {
    if (subscriber != null && !subscriber.isUnsubscribed()) {
      subscriber.onNext(data);
      if (isComplete) {
        subscriber.onCompleted();
      }
    }
  }
}
