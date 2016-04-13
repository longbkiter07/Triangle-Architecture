package mobile.silong.mvvm.data.local;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by SILONG on 4/13/16.
 */
@Database(name = MVVMDatabase.NAME, version = MVVMDatabase.VERSION)
public class MVVMDatabase {

  public static final String NAME = "MVVM";

  public static final int VERSION = 1;
}
