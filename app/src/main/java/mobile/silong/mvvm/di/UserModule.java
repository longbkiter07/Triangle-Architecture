package mobile.silong.mvvm.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;
import mobile.silong.mvvm.presentation.ListUserViewModel;
import mobile.silong.mvvm.presentation.SingleUserViewModel;

/**
 * Created by lamtn on 4/15/16.
 */
@Module
public class UserModule {

  private String mUserId;

  public UserModule() {

  }

  public UserModule(String userId) {
    mUserId = userId;
  }

  @Provides
  @Singleton
  public ListUserViewModel provideListUserViewModel(ListUserUseCase listUserUseCase) {
    return new ListUserViewModel(listUserUseCase);
  }

  @Provides
  @Singleton
  public SingleUserViewModel provideSingleUserViewModel(SingleUserUseCase singleUserUseCase) {
    return new SingleUserViewModel(singleUserUseCase);
  }
}
