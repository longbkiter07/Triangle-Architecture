package mobile.silong.mvvm.data.api.transformer;

import mobile.silong.mvvm.data.api.BaseResponse;
import mobile.silong.mvvm.data.api.exception.ApiException;
import rx.Observable;

/**
 * Created by SILONG on 5/2/16.
 */
public class BaseApiTransformer<T> implements Observable.Transformer<BaseResponse<T>, T> {

  @Override
  public Observable<T> call(Observable<BaseResponse<T>> baseResponseObservable) {
    return baseResponseObservable.flatMap(tBaseResponse -> {
      switch (tBaseResponse.getCode()) {
        case 400://successful
          return Observable.just(tBaseResponse.getData());
        default:
          return Observable.error(new ApiException());
      }
    });
  }
}
