package com.fracta7.csgostats.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("value")
    @Expose
    val value: Int?
)