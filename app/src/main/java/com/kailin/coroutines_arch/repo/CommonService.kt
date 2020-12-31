package com.kailin.coroutines_arch.repo

import com.kailin.coroutines_arch.repo.common.Categories
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CommonService {

    @GET("api/v2.1/categories")
    fun categoriesAsync(): Deferred<Categories>
}