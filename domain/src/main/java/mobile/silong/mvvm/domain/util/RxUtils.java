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
