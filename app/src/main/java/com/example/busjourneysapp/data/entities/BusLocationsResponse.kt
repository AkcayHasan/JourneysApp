package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class BusLocationsResponse(
    @SerializedName("status")
    val status: String,
    @SerializedName("data")
    val busLocationsData: List<BusLocationsDataDto>,
    @SerializedName("message")
    val message: Any,
    @SerializedName("user-message")
    val userMessage: Any,
    @SerializedName("api-request-id")
    val apiRequestId: Any,
    @SerializedName("controller")
    val controller: String,
    @SerializedName("client-request-id")
    val clientRequestId: Any
)
