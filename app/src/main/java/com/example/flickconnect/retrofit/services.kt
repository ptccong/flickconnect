package com.example.flickconnect.retrofit

import com.example.flickconnect.model.photoApp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface services {
    @GET("services/rest")
    fun getPhoto(@Query("method") method:String,
                 @Query("api_key")  api_key:String,
                 @Query("user_id") user_id:String,
                 @Query("extras") extras:String,
                 @Query("page")  page:Int,
                 @Query("per_page")  per_page:Int,
                 @Query("format") format:String,
                 @Query("nojsoncallback") nojsoncallback:Int): Call<photoApp>
}