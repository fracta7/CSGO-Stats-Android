package com.fracta7.csgostats.domain.model

data class UserStats(
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
