package mobile.silong.mvvm.view.listuser;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import mobile.silong.mvvm.R;
import mobile.silong.mvvm.adapter.UserAdapter;
import mobile.silong.mvvm.domain.model.User;
import mobile.silong.mvvm.model.AppUser;

public class ListUserActivity extends AppCompatActivity
        implements ListUserView {

  @Bind(android.R.id.list)
  RecyclerView vRecyclerUsers;

  @Bind(R.id.loading)
  ProgressBar vProgressLoading;

  @Bind(R.id.retry)
  TextView vTextRetry;

  private UserAdapter mUserAdapter;

  @Inject
  ListUserPresenter mListUserPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mListUserPresenter.attachView(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    initData();
    initViews();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mListUserPresenter.detachView();
    ButterKnife.unbind(this);
  }

  @Override
  public void renderListUser(List<AppUser> users) {
    if (mUserAdapter != null) {
      mUserAdapter.setUserList(users);
    }
  }

  @Override
  public void viewUser(User user) {

  }

  private void initData() {
    this.mUserAdapter = new UserAdapter(this);
  }

  private void initViews() {
    vRecyclerUsers.setLayoutManager(new LinearLayoutManager(this));
    vRecyclerUsers.setHasFixedSize(true);
    vRecyclerUsers.setAdapter(mUserAdapter);
  }

  @Override
  public void showLoading() {
    vProgressLoading.setVisibility(View.VISIBLE);
    vRecyclerUsers.setVisibility(View.GONE);
    vTextRetry.setVisibility(View.GONE);
  }

  @Override
  public void hideLoading() {
    vProgressLoading.setVisibility(View.GONE);
  }

  @Override
  public void showRetry() {
    vTextRetry.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideRetry() {
    vTextRetry.setVisibility(View.GONE);
  }

  @Override
  public void showError(String message) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
  }

  @Override
  public Context context() {
    return this;
  }
}
