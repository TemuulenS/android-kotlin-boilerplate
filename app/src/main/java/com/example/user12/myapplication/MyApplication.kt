package com.example.user12.myapplication

import android.app.Application
import android.content.Context
import android.util.Log
import javax.inject.Inject

/**
 * Created by user12 on 8/22/17.
 */
class MyApplication: Application() {

  companion object {
    //platformStatic allow access it from java code
    @JvmStatic lateinit var graph: ApplicationComponent
    lateinit var myApp: MyApplication
  }

  @Inject
  lateinit var context: Context

  override fun onCreate() {
    super.onCreate()
    myApp = this
    graph = DaggerApplicationComponent.builder().appModule(AppModule(this)).networkModule(NetworkModule(this)).build()
    graph.inject(this)

    Log.d("tag", context.toString())
  }

  fun getApplicationComponent(): ApplicationComponent = graph
  fun getApplicatioin(): MyApplication = myApp



}