package mobile.silong.mvvm.domain.di;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.domain.service.ApiService;
import mobile.silong.mvvm.domain.service.LocalService;
import mobile.silong.mvvm.domain.usecase.GetAndSaveUserUseCase;
import mobile.silong.mvvm.domain.usecase.ListUserUseCase;
import mobile.silong.mvvm.domain.usecase.SingleUserUseCase;

/**
 * Created by SILONG on 4/13/16.
 */
@Module
public class DomainModule {

  @Provides
  public SingleUserUseCase provideSingleUserUseCase(LocalService localService, GetAndSaveUserUseCase getAndSaveUserUseCase) {
    return new SingleUserUseCase(localService, getAndSaveUserUseCase);
  }

  @Provides
  public ListUserUseCase provideListUserUseCase(ApiService apiService) {
    return new ListUserUseCase(apiService);
  }

  @Provides
  public GetAndSaveUserUseCase provideGetAndSaveUserUseCase(ApiService apiService, LocalService localService) {
    return new GetAndSaveUserUseCase(apiService, localService);
  }
}
