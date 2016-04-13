package mobile.silong.mvvm.domain.di;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.domain.service.ApiService;
import mobile.silong.mvvm.domain.service.LocalService;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;

/**
 * Created by SILONG on 4/13/16.
 */
@Module
public class DomainModule {

  @Provides
  public SingleUserUseCase provideSingleUserUseCase(ApiService apiService, LocalService localService) {
    return new SingleUserUseCase(apiService, localService);
  }

  @Provides
  public ListUserUseCase provideListUserUseCase(ApiService apiService, LocalService localService) {
    return new ListUserUseCase(apiService, localService);
  }
}
