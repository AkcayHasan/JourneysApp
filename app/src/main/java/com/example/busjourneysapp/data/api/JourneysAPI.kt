package com.example.busjourneysapp.data.api

import com.example.busjourneysapp.data.entities.BusLocationsRequest
import com.example.busjourneysapp.data.entities.BusLocationsResponse
import com.example.busjourneysapp.data.entities.SessionRequest
import com.example.busjourneysapp.data.entities.SessionResponse
import com.example.busjourneysapp.util.Resource
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface JourneysAPI {

    @Headers("Authorization: Basic JEcYcEMyantZV095WVc3G2JtVjNZbWx1")
    @POST("client/getsession")
    suspend fun getSession(
        @Body sessionRequest: SessionRequest
    ): Resource<SessionResponse>

    @Headers("Authorization: Basic JEcYcEMyantZV095WVc3G2JtVjNZbWx1")
    @POST("location/getbuslocations")
    suspend fun getBusLocations(
        @Body busLocationsRequest: BusLocationsRequest
    ): Resource<BusLocationsResponse>

}