package com.example.busjourneysapp.domain

import com.example.busjourneysapp.data.entities.BusLocationsRequest
import com.example.busjourneysapp.data.entities.BusLocationsResponse
import com.example.busjourneysapp.data.entities.SessionRequest
import com.example.busjourneysapp.data.entities.SessionResponse
import com.example.busjourneysapp.util.Resource

interface IJourneyRepository {

    suspend fun getSession(sessionRequest: SessionRequest) : Resource<SessionResponse>
    suspend fun getBusLocations(busLocationsRequest: BusLocationsRequest) : Resource<BusLocationsResponse>

}