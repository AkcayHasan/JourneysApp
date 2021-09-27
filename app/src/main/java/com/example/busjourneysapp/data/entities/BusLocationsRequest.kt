package com.example.busjourneysapp.data.entities

data class BusLocationsRequest(
    val busLocationsRequestData: String?,
    val deviceSessionDto: DeviceSessionDto,
    val date: String ?= "",
    val language: String ?= ""
)
