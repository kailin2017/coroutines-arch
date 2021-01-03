package com.kailin.coroutines_arch.ui.home

import com.kailin.coroutines_arch.app.BaseViewModel
import com.kailin.coroutines_arch.repo.typicode.TypiService

class HomeViewModel : BaseViewModel() {

    private val typiService = okHttpHelper.create(TypiService::class.java)
    val typiCodes= liveData { emit(typiService.typiCodesAsync().await()) }
}