package com.fracta7.csgostats.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
@Entity(tableName = "remotestats")
data class Stats(
    @PrimaryKey val uid: Int? = null,
    @SerializedName("name")
    @Expose
    val name: String?,
    @SerializedName("value")
    @Expose
    val value: Int?
)