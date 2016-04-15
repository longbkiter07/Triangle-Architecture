package mobile.silong.mvvm.presentation.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;
import mobile.silong.mvvm.presentation.ListUserViewModel;
import mobile.silong.mvvm.presentation.SingleUserViewModel;

/**
 * Created by SILONG on 4/14/16.
 */
@Module
public class PresentationModule {

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
