/*
 * Copyright(c) 2016 "Si Long <long.bkiter07@gmail.com>"
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package mobile.silong.mvvm.data.local;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

import mobile.silong.data.BuildConfig;
import mobile.silong.mvvm.data.DataApp;
import mobile.silong.mvvm.data.di.DaggerDataComponent;
import mobile.silong.mvvm.data.di.DataComponent;
import mobile.silong.mvvm.data.di.DataModule;
import mobile.silong.mvvm.data.local.converter.CacheUserConverter;
import mobile.silong.mvvm.data.local.model.CacheUser;
import mobile.silong.mvvm.domain.model.User;
import rx.Observable;
import rx.observers.TestSubscriber;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lamtn on 4/20/16.
 */
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class DatabaseServiceTest {

  private DataComponent mDataComponent;

  private DatabaseService mDatabaseService;

  @Before
  public void setup() {
    if (mDataComponent == null) {
      mDataComponent = DaggerDataComponent.builder()
          .dataModule(new DataModule())
          .build();
    }

    CacheUserConverter cacheUserConverter = new CacheUserConverter();
    mDatabaseService = new DatabaseService(cacheUserConverter);

    DataApp.init(RuntimeEnvironment.application);
  }

  @Test
  public void testObserveLocalChange() throws Exception {

  }

  @Test
  public void testGetUser() throws Exception {
    TestSubscriber<User> testSubscriber = new TestSubscriber<>();
    CacheUser cacheUser = new CacheUser("1", "Lam", "lam@mysquar.com", "Lam", "123", "http://lamtran.net");
    mDatabaseService.saveUser(cacheUser)
        .flatMap(aVoid -> mDatabaseService.getUser(cacheUser.getId()))
        .subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertCompleted();

    List<User> users = testSubscriber.getOnNextEvents();

    User user = users.get(0);

    assertThat(user, notNullValue());

    assertThat(user.getId(), equalTo(cacheUser.getId()));
    assertThat(user.getCoverUrl(), equalTo(cacheUser.getCoverUrl()));
    assertThat(user.getDescription(), equalTo(cacheUser.getDescription()));
    assertThat(user.getEmail(), equalTo(cacheUser.getEmail()));
    assertThat(user.getFollowers(), equalTo(cacheUser.getFollowers()));
    assertThat(user.getFullName(), equalTo(cacheUser.getFullName()));
  }

  @Test
  public void testGetUsers() throws Exception {
    List<User> cacheUsers = new ArrayList<>();
    cacheUsers.add(new CacheUser("1", "Lam", "lam@mysquar.com", "Lam", "123", "http://lamtran.net"));
    cacheUsers.add(new CacheUser("2", "Henry", "henry@mysquar.com", "Henry", "456", "http://henrytao.me"));
    cacheUsers.add(new CacheUser("3", "Long", "long@mysquar.com", "Long", "789", "http://silong.me"));

    mDatabaseService.saveUsers(cacheUsers).subscribe();

    TestSubscriber<List<? extends User>> testSubscriber = new TestSubscriber<>();
    mDatabaseService.getUsers().subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertCompleted();

    List<? extends User> users = testSubscriber.getOnNextEvents().get(0);

    assertThat(users.size(), equalTo(cacheUsers.size()));

    for (int i = 0; i < users.size(); i++) {
      assertThat(users.get(i).getId(), equalTo(cacheUsers.get(i).getId()));
      assertThat(users.get(i).getCoverUrl(), equalTo(cacheUsers.get(i).getCoverUrl()));
      assertThat(users.get(i).getDescription(), equalTo(cacheUsers.get(i).getDescription()));
      assertThat(users.get(i).getEmail(), equalTo(cacheUsers.get(i).getEmail()));
      assertThat(users.get(i).getFollowers(), equalTo(cacheUsers.get(i).getFollowers()));
      assertThat(users.get(i).getFullName(), equalTo(cacheUsers.get(i).getFullName()));
    }
  }

  @Test
  public void testRemoveUser() throws Exception {
    TestSubscriber<Void> testSaveSubscriber = new TestSubscriber<>();

    CacheUser cacheUser = new CacheUser("1", "Lam", "lam@mysquar.com", "Lam", "123", "http://lamtran.net");
    mDatabaseService.saveUser(cacheUser)
        .flatMap(aVoid -> mDatabaseService.removeUser(cacheUser.getId()))
        .subscribe(testSaveSubscriber);

    testSaveSubscriber.assertNoErrors();
    testSaveSubscriber.assertCompleted();

    TestSubscriber<User> testGetSubscriber = new TestSubscriber<>();

    mDatabaseService.getUser(cacheUser.getId())
        .subscribe(testGetSubscriber);

    List<User> users = testGetSubscriber.getOnNextEvents();

    assertThat(users.size(), equalTo(0));
  }

  @Test
  public void testRemoveUsers() throws Exception {

    List<User> cacheUsers = new ArrayList<>();
    cacheUsers.add(new CacheUser("1", "Lam", "lam@mysquar.com", "Lam", "123", "http://lamtran.net"));
    cacheUsers.add(new CacheUser("2", "Henry", "henry@mysquar.com", "Henry", "456", "http://henrytao.me"));
    cacheUsers.add(new CacheUser("3", "Long", "long@mysquar.com", "Long", "789", "http://silong.me"));

    mDatabaseService.saveUsers(cacheUsers)
        .subscribe();

    TestSubscriber<Void> testSubscriber = new TestSubscriber<>();

    Observable.from(cacheUsers)
        .map(user -> user.getId())
        .toList()
        .flatMap(strings -> mDatabaseService.removeUsers(strings))
        .subscribe(testSubscriber);

    testSubscriber.assertNoErrors();
    testSubscriber.assertCompleted();

    TestSubscriber<List<? extends User>> testGetSubscriber = new TestSubscriber<>();

    mDatabaseService.getUsers()
        .subscribe(testGetSubscriber);

    List<? extends User> users = testGetSubscriber.getOnNextEvents().get(0);

    assertThat(users.size(), equalTo(0));
  }
}