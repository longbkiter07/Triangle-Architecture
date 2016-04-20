package mobile.silong.mvvm.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lamtn on 4/15/16.
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {}