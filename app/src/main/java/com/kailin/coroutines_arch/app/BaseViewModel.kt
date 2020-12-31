package com.kailin.traffic.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kailin.coroutines_arch.utils.OkHttpHelper
import kotlinx.coroutines.*

abstract class BaseViewModel : ViewModel(), CoroutineScope by MainScope() {

    val msgText: MutableLiveData<String> by lazy { MutableLiveData() }
    val loading: MutableLiveData<Boolean> by lazy { MutableLiveData(false) }
    protected val okHttpHelper: OkHttpHelper by lazy { OkHttpHelper.instance }

    fun onError(e: Throwable) {
        e.printStackTrace()
        msgText.postValue(e.message)
    }

    fun runIO(method: suspend () -> Unit) {
        launch(Dispatchers.IO) { method() }
    }

//    fun getString(@StringRes stringId: Int): String {
//        return StringUtil.instance.getString(stringId)
//    }

    override fun onCleared() {
        super.onCleared()
        cancel()
    }
}