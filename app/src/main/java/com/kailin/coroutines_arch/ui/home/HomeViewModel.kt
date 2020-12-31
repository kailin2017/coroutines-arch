package com.kailin.coroutines_arch.ui.home

import androidx.lifecycle.MutableLiveData
import com.kailin.coroutines_arch.repo.CommonService
import com.kailin.coroutines_arch.repo.common.Categories
import com.kailin.traffic.app.BaseViewModel

class HomeViewModel : BaseViewModel() {

    private val commonService: CommonService by lazy { okHttpHelper.create(CommonService::class.java) }
    val categorieData: MutableLiveData<Categories> by lazy { MutableLiveData() }

    fun initData() {
        runIO {
            val result = commonService.categoriesAsync().await()
            categorieData.postValue(result)
        }
    }
}