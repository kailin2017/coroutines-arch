package com.kailin.coroutines_arch.utils

import okhttp3.Interceptor
import okhttp3.Response

class OkHttpInterceptor private constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().run {
            addHeader("user-key", "13a05c2bf984177047f73bb4b095f06d")
            build()
        }
        return chain.proceed(request)
    }

    companion object {
        val instance: OkHttpInterceptor by lazy { OkHttpInterceptor() }
    }
}