package com.kailin.coroutines_arch.app

import androidx.lifecycle.*
import com.kailin.coroutines_arch.utils.OkHttpHelper
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.experimental.ExperimentalTypeInference

abstract class BaseViewModel : ViewModel() {

    val msgText: MutableLiveData<String> by lazy { MutableLiveData() }
    val loading: MutableLiveData<Boolean> by lazy { MutableLiveData(false) }
    protected val okHttpHelper: OkHttpHelper by lazy { OkHttpHelper.instance }

    fun onError(e: Throwable) {
        e.printStackTrace()
        msgText.postValue(e.message)
    }

    @UseExperimental(ExperimentalTypeInference::class)
    fun <T> liveData(
        context: CoroutineContext = EmptyCoroutineContext,
        timeoutInMs: Long = 5000L,
        @BuilderInference block: suspend LiveDataScope<T>.() -> Unit
    ): LiveData<T> = try {
        androidx.lifecycle.liveData(context, timeoutInMs, block)
    } catch (e: Exception) {
        onError(e)
        MutableLiveData()
    }

//    fun getString(@StringRes stringId: Int): String {
//        return StringUtil.instance.getString(stringId)
//    }
}