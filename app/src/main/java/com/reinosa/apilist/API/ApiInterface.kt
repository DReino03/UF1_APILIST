package com.reinosa.apilist.API

import com.reinosa.apilist.Model.Data
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    //"4755d6dce061428b93c6cbe80a4d5288"
    //9e0237c5442b480ea63e993a42e0f714
    @GET("v2/everything?q=bitcoin&apiKey=9e0237c5442b480ea63e993a42e0f714")
    suspend fun getNoticias(): Response<Data>

    companion object {
        val BASE_URL = "https://newsapi.org/"
        fun create(): ApiInterface {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }



}