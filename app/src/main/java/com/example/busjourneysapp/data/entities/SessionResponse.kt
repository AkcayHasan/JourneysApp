package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class SessionResponse(
    @SerializedName("api-request-id")
    val apiRequestId: Any,
    @SerializedName("controller")
    val controller: Any,
    @SerializedName("data")
    val sessionDataDto: SessionDataDto,
    @SerializedName("message")
    val message: Any,
    @SerializedName("status")
    val status: String,
    @SerializedName("user-message")
    val userMessage: Any
)