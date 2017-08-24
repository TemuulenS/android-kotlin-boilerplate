package com.example.user12.myapplication

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by user12 on 8/22/17.
 */
@Module
class AppModule (private val application: MyApplication){
  /**
   * Allow the application context to be injected but require that it be annotated with [ ][ForApplication] to explicitly differentiate it from an activity context.
   */
  @Provides
  @Singleton
  fun provideApplicationContext(): Context {
    return application
  }
}