package com.example.busjourneysapp.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import timber.log.Timber
import java.lang.Exception

class HomeViewModel(

    private val viewModelParams: ViewModelParams
) : AndroidViewModel(viewModelParams.application) {

    init {
        viewModelScope.launch {
            getSessionIds()
        }
    }

    private suspend fun getSessionIds() {
        viewModelScope.launch {
            try {
                viewModelParams.sessionUseCase.getSessionIds().collect {
                    Timber.d("current thread: ${Thread.currentThread().name}")
                    it.data?.let { sessionResponse ->
                        viewModelParams.customSharedPref.saveSessionId(sessionResponse.sessionDataDto.sessionId)
                        viewModelParams.customSharedPref.saveDeviceId(sessionResponse.sessionDataDto.deviceId)
                    }
                }
            }catch (e : Exception){
                e.printStackTrace()
            }

        }
    }

}