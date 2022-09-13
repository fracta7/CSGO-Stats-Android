package com.fracta7.csgostats.data.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JSONModel(

    @SerializedName("playerstats")
    @Expose
    val playerStats: PlayerStatsJSON
)