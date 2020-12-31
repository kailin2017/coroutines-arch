package com.kailin.coroutines_arch.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.kailin.coroutines_arch.repo.typicode.TypiCode
import com.kailin.coroutines_arch.repo.typicode.TypiService
import com.kailin.traffic.app.BaseViewModel

class HomeViewModel : BaseViewModel() {

    val typiCodes: LiveData<MutableList<TypiCode>>

    init {
        val service = okHttpHelper.create(TypiService::class.java)
        typiCodes = liveData { emit(service.typiCodesAsync().await()) }
    }
}