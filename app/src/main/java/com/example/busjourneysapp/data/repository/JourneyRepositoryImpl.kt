package com.example.busjourneysapp.data.repository

import com.example.busjourneysapp.BuildConfig
import com.example.busjourneysapp.data.api.JourneysAPI
import com.example.busjourneysapp.data.api.RetrofitInstance
import com.example.busjourneysapp.data.entities.BusLocationsRequest
import com.example.busjourneysapp.data.entities.BusLocationsResponse
import com.example.busjourneysapp.data.entities.SessionRequest
import com.example.busjourneysapp.data.entities.SessionResponse
import com.example.busjourneysapp.domain.IJourneyRepository
import com.example.busjourneysapp.util.Resource

class JourneyRepositoryImpl : IJourneyRepository{

    private val request : JourneysAPI
        get() = RetrofitInstance.getClient(BuildConfig.BASE_URL).create(JourneysAPI::class.java)

    override suspend fun getSession(sessionRequest: SessionRequest): Resource<SessionResponse> {
        return request.getSession(sessionRequest)
    }

    override suspend fun getBusLocations(busLocationsRequest: BusLocationsRequest): Resource<BusLocationsResponse> {
        return request.getBusLocations(busLocationsRequest)
    }


}