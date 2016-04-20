package mobile.silong.mvvm.view.singleuser.di;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.di.PerActivity;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;
import mobile.silong.mvvm.presentation.SingleUserViewModel;

/**
 * Created by SILONG on 4/20/16.
 */
@Module
public class SingleUserModule {

  String mUserId;

  public SingleUserModule(String userId) {
    mUserId = userId;
  }

  @Provides
  @PerActivity
  public SingleUserViewModel provideUserViewModel(SingleUserUseCase singleUserUseCase) {
    return new SingleUserViewModel(mUserId, singleUserUseCase);
  }
}
