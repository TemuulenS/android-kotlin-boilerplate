package com.example.user12.myapplication

import com.example.user12.myapplication.data.remote.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by user12 on 8/23/17.
 */
@Module
class NetworkModule(myApplication: MyApplication) {

  companion object {
    val BASE_URL = "https://api.github.com/"
  }

  @Singleton
  @Provides
  fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
    var retroFit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
    return retroFit
  }

  @Singleton
  @Provides
  fun providesHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

  @Provides
  fun providesApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}