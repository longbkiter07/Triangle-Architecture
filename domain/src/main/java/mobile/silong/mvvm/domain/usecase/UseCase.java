package mobile.silong.mvvm.domain.usecase;

import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public interface UseCase<T> {

  Observable<T> buildUseCase();
}
