# Triangle-Architecture
Got idea from [Android Clean Architecture](https://github.com/android10/Android-CleanArchitecture), this is a very simple Android app which describes how we can design a clean and clear architecture for an Android App.
This example is using:
- [Dagger 2](http://google.github.io/dagger/) for dependency injection
- [Retrofit](http://square.github.io/retrofit/) and [OkHttp](http://square.github.io/okhttp/) for http requests
- [DBFlow](https://github.com/Raizlabs/DBFlow) for saving objects to database
- [Robolectric](http://robolectric.org/) for unit testing
- [RxJava and RxAndroid](https://github.com/ReactiveX/RxJava) for simplify the business logic
- [MultiStateView](https://github.com/Kennyc1012/MultiStateView) for changing view state

# Concept

![Alt text](https://github.com/longbkiter07/Triangle-Architecture/blob/master/concept.jpg)

#### Data
By using repository pattern, data is a module which contains implementation everything relates to data, for example: database, api call, or from a third party service.
#### Domain
Domain defines interfaces of DataService, DataModel and uses them to build UseCases which contain the app business logic.
#### Presentation
By using MVVM with Data Binding, Presentation layer uses Domain UseCases to present the business logic on view.

# Discussions
Welcome everyone to discuss about this architecture [here] (https://github.com/longbkiter07/Triangle-Architecture/issues).

# Thanks
A big thanks to [Android-10](https://github.com/android10) for the Android Clean Architecture.
Thanks to [Lam](https://github.com/tranngoclam) for Presentation layer implematation.
# License
```
Copyright(c) 2016 "Si Long <long.bkiter07@gmail.com>"

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
