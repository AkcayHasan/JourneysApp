package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class SessionRequest(
    @SerializedName("application")
    val sessionApplicationDto: SessionApplicationDto,
    @SerializedName("connection")
    val sessionConnectionDto: SessionConnectionDto,
    @SerializedName("type")
    val type: Int
)