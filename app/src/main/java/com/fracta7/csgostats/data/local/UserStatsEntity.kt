package com.fracta7.csgostats.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userstats")
data class UserStatsEntity(
    @PrimaryKey val uid: Int? = null,
    val map: Int?,
    val duration: Int?,
    val date: String?,
    val kills: Int?,
    val assists: Int?,
    val deaths: Int?,
    val hs: Float?,
    val dpr: Float?,
    val mvps: Int?,
    val matchScore: String?,
    val startedAsCT: Boolean?
)
