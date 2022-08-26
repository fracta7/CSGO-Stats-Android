package com.fracta7.csgostats.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PlayerStatsJSON(
    @SerializedName("steamID")
    @Expose
    val steamID: String?,
    @SerializedName("gameName")
    @Expose
    val gameName: String?,
    @SerializedName("stats")
    @Expose
    val stats: ArrayList<Stats>?
)
