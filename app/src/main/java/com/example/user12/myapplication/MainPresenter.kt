package com.example.user12.myapplication

import android.util.Log
import com.google.gson.JsonArray
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject
import com.example.user12.myapplication.data.remote.ApiService

/**
 * Created by user12 on 8/24/17.
 */
class MainPresenter(mainView: MainView){


  @Inject
  lateinit var apiService : ApiService

  companion object {
    lateinit var view: MainView
  }

  init {
    view = mainView
    MyApplication.graph.inject(this)
  }

  fun initalize() {
    view.initViews()
  }

  fun sendRequest(toString: String) {
    apiService.listRepos(toString)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(object : Subscriber<JsonArray>()
        {
          override fun onCompleted() {
          }

          override fun onNext(t: JsonArray) {
            view.showData(t)
          }

          override fun onError(e: Throwable?) {
            Log.e("tag", e!!.message)
          }
        }
        )
  }

}