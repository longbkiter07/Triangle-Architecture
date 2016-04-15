package mobile.silong.mvvm.presentation.util;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import mobile.silong.mvvm.adapter.UserAdapter;
import mobile.silong.mvvm.domain.model.User;

/**
 * Created by lamtn on 4/14/16.
 */
public class BindingUtil {

  private BindingUtil() {

  }

  @BindingAdapter("bind:userList")
  public static void loadUserList(RecyclerView recyclerView, List<User> users) {
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
}
