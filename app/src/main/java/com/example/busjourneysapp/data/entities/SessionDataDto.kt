package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class SessionDataDto(
    @SerializedName("device-id")
    val deviceId: String,
    @SerializedName("session-id")
    val sessionId: String,
    @SerializedName("affiliate")
    val affiliate: Any,
    @SerializedName("device-type")
    val deviceType: Int,
    @SerializedName("device")
    val device: Any
)