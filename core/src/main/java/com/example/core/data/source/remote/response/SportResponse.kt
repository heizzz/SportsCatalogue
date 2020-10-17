package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SportResponse(
    @field:SerializedName("idSport")
    val id: String,

    @field:SerializedName("strSport")
    val name: String,

    @field:SerializedName("strFormat")
    val format: String,

    @field:SerializedName("strSportThumb")
    val thumb: String,

    @field:SerializedName("strSportThumbGreen")
    val thumbGreen: String,

    @field:SerializedName("strSportDescription")
    val description: String
)