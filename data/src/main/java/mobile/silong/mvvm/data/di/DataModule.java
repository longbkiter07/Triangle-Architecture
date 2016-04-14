package mobile.silong.mvvm.data.di;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import mobile.silong.mvvm.data.api.HttpApiService;
import mobile.silong.mvvm.data.local.DatabaseService;
import mobile.silong.mvvm.data.local.converter.CacheUserConverter;
import mobile.silong.mvvm.domain.converter.MVVMConverter;
import mobile.silong.mvvm.data.local.model.CacheUser;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.domain.service.ApiService;
import mobile.silong.mvvm.domain.service.LocalService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SILONG on 4/13/16.
 */
@Module
public class DataModule {

  @Provides
  @Singleton
  public LocalService provideLocalService(MVVMConverter<User, CacheUser> converter) {
    return new DatabaseService(converter);
  }

  @Provides
  @Singleton
  public MVVMConverter<User, CacheUser> provideCacheUserConverter() {
    return new CacheUserConverter();
  }

  @Provides
  @Singleton
  public ApiService provideApiService(OkHttpClient okHttpClient, Gson gson) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://www.android10.org/myapi/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(okHttpClient)
        .build();
    return retrofit.create(HttpApiService.class);
  }

  @Provides
  @Singleton
  public OkHttpClient provideOkHttp() {
    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return new OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(35, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build();
  }

  @Provides
  @Singleton
  public Gson provideGson() {
    return new Gson();
  }


}
