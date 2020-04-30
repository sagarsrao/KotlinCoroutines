package com.mindorks.example.coroutines.data.api

import com.itkacher.okhttpprofiler.OkHttpProfilerInterceptor
import com.mindorks.example.coroutines.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val BASE_URL = "https://5e510330f2c0d300147c034c.mockapi.io/"

    val builder = OkHttpClient.Builder()


    private fun getRetrofit(): Retrofit {
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(OkHttpProfilerInterceptor())
        }
        val client = builder.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                client)
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}