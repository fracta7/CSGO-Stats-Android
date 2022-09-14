package com.fracta7.csgostats.data.local.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinfo")
data class UserInfoEntity(
    @PrimaryKey val uid: Int? = null,
    val steamId: String?
)
