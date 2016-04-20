package mobile.silong.mvvm.presentation.util;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.kennyc.view.MultiStateView;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;

import java.util.List;

import mobile.silong.mvvm.adapter.UserAdapter;
import mobile.silong.mvvm.domain.model.User;

/**
 * Created by lamtn on 4/14/16.
 */
public class BindingUtil {

  private static final String TAG = BindingUtil.class.getSimpleName();

  private BindingUtil() {

  }

  /**
   * Bind list of users to a RecyclerView
   */
  @BindingAdapter("bind:userList")
  public static void loadUserList(RecyclerView recyclerView, List<User> users) {
    Log.i(TAG, "loadUserList: " + users);

    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
    if (layoutManager == null) {
      recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }
    RecyclerView.Adapter adapter = recyclerView.getAdapter();
    if (adapter == null) {
      adapter = new UserAdapter(recyclerView.getContext());
      recyclerView.setAdapter(adapter);
    }
    UserAdapter userAdapter = (UserAdapter) adapter;
    userAdapter.setUserList(users);
  }

  /**
   * Bind a url string to a DraweeView
   */
  @BindingAdapter("bind:imageUrl")
  public static void loadImage(DraweeView draweeView, String url) {
    if (!TextUtils.isEmpty(url)) {
      ImageRequestBuilder builder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
          .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
          .setLocalThumbnailPreviewsEnabled(true)
          .setAutoRotateEnabled(true);
      DraweeController controller = Fresco.newDraweeControllerBuilder().setImageRequest(builder.build())
          .setAutoPlayAnimations(true)
          .setOldController(draweeView.getController()).build();
      draweeView.setController(controller);
    }
  }

  @BindingAdapter("bind:stateView")
  public static void setState(MultiStateView multiStateView, int state) {
    if (multiStateView.getViewState() != state) {
      multiStateView.setViewState(state);
    }
  }
}
