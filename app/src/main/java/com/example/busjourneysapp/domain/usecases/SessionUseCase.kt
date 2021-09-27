package com.example.busjourneysapp.domain.usecases

import android.content.Context
import com.example.busjourneysapp.App
import com.example.busjourneysapp.data.entities.*
import com.example.busjourneysapp.domain.IJourneyRepository
import com.example.busjourneysapp.domain.entities.Session
import com.example.busjourneysapp.util.CustomSharedPref
import com.example.busjourneysapp.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SessionUseCase(private val journeyRepository: IJourneyRepository) {

    private var locationQuery :String ?= null
    private val sessionRequest = SessionRequest(SessionApplicationDto(), SessionConnectionDto(), 3)

    suspend fun getSessionIds(): Flow<Resource<SessionResponse>> {
        return flow {
            val result = journeyRepository.getSession(sessionRequest)
            emit(Resource.loading(null))
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getBusLocations(): Flow<Resource<BusLocationsResponse>> {
        val busLocationsRequest = BusLocationsRequest(locationQuery, DeviceSessionDto(App.sessionId, App.deviceId))

        return flow {
            val result = journeyRepository.getBusLocations(busLocationsRequest)
            emit(Resource.loading(null))
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    fun busLocationQuery(locationQuery: String){
        this.locationQuery = locationQuery
    }

}