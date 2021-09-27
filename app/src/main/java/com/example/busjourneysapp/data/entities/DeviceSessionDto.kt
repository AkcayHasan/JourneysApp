package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class DeviceSessionDto(
    @SerializedName("session-id")
    val sessionId: String,
    @SerializedName("device-id")
    val deviceId: String
)