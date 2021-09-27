package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class SessionApplicationDto(
    @SerializedName("equipment-id")
    val equipmentId: String ?= "DD2A0857-7C7D-4376-A83B-E045435E82BB",
    @SerializedName("version")
    val version: String ?= "3.1.0.0"
)