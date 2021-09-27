package com.example.busjourneysapp.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.busjourneysapp.domain.entities.BusLocations
import com.example.busjourneysapp.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BusViewModel(private val viewModelParams: ViewModelParams) :
    AndroidViewModel(viewModelParams.application) {
/*
    private val busLocationsList = MutableStateFlow<Resource<BusLocations>>(Resource.success(null))
    val locationsList : StateFlow<Resource<BusLocations>>
        get() = busLocationsList

 */


    fun getBusLocations(locationQuery: String) {

        viewModelParams.sessionUseCase.busLocationQuery(locationQuery)
/*
        viewModelScope.launch {
            viewModelParams.sessionUseCase.getBusLocations().collect {
                //busLocationsList.value = Resource.success(it.data)

            }
        }

 */
    }
}