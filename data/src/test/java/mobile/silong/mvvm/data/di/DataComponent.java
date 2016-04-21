package mobile.silong.mvvm.data.di;

import dagger.Component;
import mobile.silong.mvvm.data.local.DatabaseServiceTest;

/**
 * Created by lamtn on 4/20/16.
 */
@Component(modules = DataModule.class)
public interface DataComponent {

  void inject(DatabaseServiceTest databaseServiceTest);
}
