/*
 * Copyright(c) 2016 "Si Long <long.bkiter07@gmail.com>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
