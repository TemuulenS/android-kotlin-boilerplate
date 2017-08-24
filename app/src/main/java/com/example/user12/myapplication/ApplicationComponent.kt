package com.example.user12.myapplication

import dagger.Component
import javax.inject.Singleton

/**
 * Created by user12 on 8/22/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class) )
interface ApplicationComponent {
  fun inject(myApplication: MyApplication)
  fun inject(mainPresenter: MainPresenter)
}