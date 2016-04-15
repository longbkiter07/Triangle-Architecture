package mobile.silong.mvvm.presentation;

import android.databinding.BaseObservable;
import android.os.Bundle;

import mobile.silong.mvvm.view.MVVMView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.subjects.BehaviorSubject;

/**
 * Created by SILONG on 4/14/16.
 */
public class BaseViewModel<V extends MVVMView> extends BaseObservable {

  private BehaviorSubject<V> mSubject;

  public BaseViewModel() {
    mSubject = BehaviorSubject.create();
  }

  public void attachView(V view) {
    mSubject.onNext(view);
  }

  public void detachView() {
    mSubject.onNext(null);
    mSubject.onCompleted();
    mSubject = BehaviorSubject.create();
  }

  public void onCreate(Bundle savedInstanceState) {

  }

  public void onDestroy() {

  }

  public void onResume() {

  }

  public void onPause() {

  }

  public Observable<V> getView() {
    return mSubject
        .filter(v -> v != null)
        .first()
        .subscribeOn(AndroidSchedulers.mainThread());
  }
}
