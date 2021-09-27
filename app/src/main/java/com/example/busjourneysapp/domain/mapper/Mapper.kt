package com.example.busjourneysapp.domain.mapper

import com.example.busjourneysapp.data.entities.BusLocationsDataDto
import com.example.busjourneysapp.data.entities.BusLocationsResponse
import com.example.busjourneysapp.data.entities.SessionResponse
import com.example.busjourneysapp.domain.entities.BusLocations
import com.example.busjourneysapp.domain.entities.BusLocationsDto
import com.example.busjourneysapp.domain.entities.Session

/*
fun SessionResponse.toSessionIds() = Session(
    deviceId = this.sessionDataDto.deviceId,
    sessionId = this.sessionDataDto.sessionId
)

 */

fun BusLocationsResponse.toBusLocations() = BusLocations(
    busLocationsDto = this.busLocationsData.map {
        it.toBusLocation()
    }
)

fun BusLocationsDataDto.toBusLocation() = BusLocationsDto(
    this.id,this.name
)

