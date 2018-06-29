package com.mutualmobile.praxis.injection.module

import com.mutualmobile.praxis.injection.scope.ActivityScope
import com.mutualmobile.praxis.ui.base.navigator.ActivityNavigator
import com.mutualmobile.praxis.ui.base.navigator.Navigator
import com.mutualmobile.praxis.ui.home.HomeActivity
import com.mutualmobile.praxis.ui.home.HomeActivityModule
import com.mutualmobile.praxis.ui.joke.ShowJokeActivity
import com.mutualmobile.praxis.ui.joke.ShowJokeActivityModule
import com.tbruyelle.rxpermissions2.RxPermissions
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.android.support.DaggerAppCompatActivity

@Module
abstract class ActivityBindingModule {

  @ActivityScope
  @ContributesAndroidInjector(
      modules = arrayOf(ShowJokeActivityModule::class)
  )
  internal abstract fun bindShowJokeActivity(): ShowJokeActivity

  @ActivityScope
  @ContributesAndroidInjector(modules = arrayOf(HomeActivityModule::class))
  internal abstract fun bindHomeActivity(): HomeActivity

}


@Module(includes = arrayOf(BaseActivityModule::class))
abstract class ActivityModule<in T : DaggerAppCompatActivity> {
  @Binds
  @ActivityScope
  internal abstract fun bindActivity(activity: T): DaggerAppCompatActivity
}

/**
 * Activity specific common dependencies should be placed here
 */
@Module
open class BaseActivityModule {
  @ActivityScope
  @Provides internal fun provideRxPermissions(activity: DaggerAppCompatActivity) = RxPermissions(
      activity
  )

  @Provides @ActivityScope internal fun provideNavigator(activity: DaggerAppCompatActivity): Navigator {
    return ActivityNavigator(activity)
  }
}