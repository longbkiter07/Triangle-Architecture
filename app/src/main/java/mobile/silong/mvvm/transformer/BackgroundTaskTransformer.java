package mobile.silong.mvvm.transformer;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lamtn on 4/14/16.
 */
public class BackgroundTaskTransformer<T> implements Observable.Transformer<T, T>{
  @Override
  public Observable<T> call(Observable<T> tObservable) {
    return tObservable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
  }
}
