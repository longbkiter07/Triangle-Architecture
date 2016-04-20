package mobile.silong.mvvm.view.listuser.di;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.di.PerActivity;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.presentation.ListUserViewModel;

/**
 * Created by SILONG on 4/20/16.
 */
@Module
public class ListUserModule {
  @Provides
  @PerActivity
  public ListUserViewModel provideListUserViewModel(ListUserUseCase listUserUseCase) {
    return new ListUserViewModel(listUserUseCase);
  }
}
