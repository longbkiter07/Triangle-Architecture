package mobile.silong.mvvm.domain.usecase;

import android.text.TextUtils;

import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.LocalService;
import rx.Observable;

/**
 * Created by SILONG on 4/13/16.
 */
public class SingleUserUseCase implements UseCase<User> {

  private static final String TAG = SingleUserUseCase.class.getSimpleName();

  private final LocalService mLocalService;

  private final GetAndSaveUserUseCase mGetAndSaveUserUseCase;

  private String mId;

  public SingleUserUseCase(LocalService localService, GetAndSaveUserUseCase getAndSaveUserUseCase) {
    mLocalService = localService;
    mGetAndSaveUserUseCase = getAndSaveUserUseCase;
  }

  public SingleUserUseCase with(String id) {
    mId = id;
    return this;
  }

  @Override
  public Observable<User> buildUseCase() {
    if (TextUtils.isEmpty(mId)) {
      return Observable.error(new IllegalArgumentException());
    } else {
      return mLocalService
          .getUser(mId)
          .onErrorResumeNext(throwable -> mGetAndSaveUserUseCase.with(mId).buildUseCase());
    }
  }
}
