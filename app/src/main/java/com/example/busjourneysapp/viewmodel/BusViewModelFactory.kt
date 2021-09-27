package com.example.busjourneysapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class BusViewModelFactory(
    private val viewModelParams: ViewModelParams
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BusViewModel::class.java)) {
            return BusViewModel(viewModelParams) as T
        }
        throw IllegalArgumentException("ViewModel Class Not Found!")
    }
}