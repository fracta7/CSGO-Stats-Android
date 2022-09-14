package com.fracta7.csgostats.data.mapper

import com.fracta7.csgostats.data.local.user.UserInfoEntity
import com.fracta7.csgostats.domain.model.UserInfo

fun UserInfoEntity.toUserInfo(): UserInfo{
    return UserInfo(steamId = steamId)
}