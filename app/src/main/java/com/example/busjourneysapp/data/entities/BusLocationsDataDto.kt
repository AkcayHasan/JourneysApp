package com.example.busjourneysapp.data.entities

import com.google.gson.annotations.SerializedName

data class BusLocationsDataDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("geo-location")
    val geoLocationDto: GeoLocationDto,
    @SerializedName("keywords")
    val keywords: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent-id")
    val parentId: Int,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("reference-code")
    val referenceCode: Any,
    @SerializedName("type")
    val type: String,
    @SerializedName("tz-code")
    val tzCode: String,
    @SerializedName("weather-code")
    val weatherCode: Any,
    @SerializedName("zoom")
    val zoom: Int
)