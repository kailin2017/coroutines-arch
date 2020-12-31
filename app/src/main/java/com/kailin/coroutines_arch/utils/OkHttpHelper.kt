package com.kailin.coroutines_arch.utils

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.kailin.coroutines_arch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class OkHttpHelper private constructor() {

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(OkHttpInterceptor.instance)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonHelper.instance.gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    fun <T> create(service: Class<T>): T = retrofit.create(service)

    companion object {
        val instance: OkHttpHelper by lazy { OkHttpHelper() }
    }
}