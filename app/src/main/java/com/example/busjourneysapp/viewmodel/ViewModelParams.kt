package com.example.busjourneysapp.viewmodel

import android.app.Application
import com.example.busjourneysapp.domain.usecases.SessionUseCase
import com.example.busjourneysapp.util.CustomSharedPref

class ViewModelParams {

    lateinit var application : Application
    lateinit var sessionUseCase: SessionUseCase
    lateinit var customSharedPref: CustomSharedPref
}