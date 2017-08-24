package com.example.user12.myapplication.data.remote

import com.google.gson.JsonArray
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable


/**
 * Created by user12 on 8/22/17.
 */
interface ApiService{

  @GET("users/{user}/repos")
  fun listRepos(@Path("user") user: String): Observable<JsonArray>

}