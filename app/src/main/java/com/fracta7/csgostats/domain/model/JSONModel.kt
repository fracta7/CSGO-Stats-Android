package com.fracta7.csgostats.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JSONModel(

    @SerializedName("playerstats")
    @Expose
    val playerStats: PlayerStatsJSON
)