package com.example.sky.models

import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

data class BestOffer(
    val id: Int,
    val image: ImageVector? = null,
    val title: String,
    val town: String,
    val price: Price
)

@Serializable
data class Price(val value: Int)
