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

package me.silong.mvvm.view.listuser.di;

import dagger.Subcomponent;
import me.silong.mvvm.di.PerActivity;
import me.silong.mvvm.presentation.ListUserViewModel;

/**
 * Created by SILONG on 4/20/16.
 */
@Subcomponent(modules = ListUserModule.class)
@PerActivity
public interface ListUserComponent {

  ListUserViewModel getListUserViewModel();
}
