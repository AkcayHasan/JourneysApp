package com.example.busjourneysapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class HomeViewModelFactory(
    private val viewModelParams: ViewModelParams
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(viewModelParams) as T
        }
        throw IllegalArgumentException("ViewModel Class Not Found!")
    }
}