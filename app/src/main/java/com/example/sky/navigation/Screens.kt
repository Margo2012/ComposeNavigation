package com.example.sky.navigation

import kotlinx.serialization.Serializable

@Serializable
object ScreenA

@Serializable
data class ScreenB(
    val name: String?,
    val age: Int
)

@Serializable
object ScreenC

@Serializable
object ScreenD

@Serializable
object ScreenE
