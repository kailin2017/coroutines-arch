package com.kailin.coroutines_arch.repo.typicode

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface TypiService {

    @GET("photos")
    fun typiCodesAsync(): Deferred<MutableList<TypiCode>>
}