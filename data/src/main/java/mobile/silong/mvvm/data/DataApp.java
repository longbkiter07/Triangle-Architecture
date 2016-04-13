package mobile.silong.mvvm.data;

import com.raizlabs.android.dbflow.config.FlowManager;

import android.content.Context;

/**
 * Created by SILONG on 4/13/16.
 */
public class DataApp {

  private DataApp() {

  }

  public static void init(Context context) {
    FlowManager.init(context);
  }
}
