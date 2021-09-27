package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class SessionConnectionDto(
    @SerializedName("ip-address")
    val ipAddress : String ?= "145.214.41.21"
)