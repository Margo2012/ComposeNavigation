package com.example.sky.ui.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.sky.R
import com.example.sky.models.BestOffer
import com.example.sky.models.Price
import com.example.sky.ui.widget.OfferItem

@Composable
fun ListBestOffer() {
    val offers = listOf(
        BestOffer(id = 1, title = "Die Antwoord", town = "Будапешт", price = Price(5000)),
        BestOffer(id = 2, title = "Socrat&Lera", town = "Санкт-Петербург", price = Price(1999)),
        BestOffer(id = 3, title = "Лампабикт", town = "Москва", price = Price(2390)),
        BestOffer(id = 11, title = "Die Antwoord", town = "Будапешт", price = Price(5000)),
        BestOffer(id = 22, title = "Socrat&Lera", town = "Санкт-Петербург", price = Price(1999)),
        BestOffer(id = 33, title = "Лампабикт", town = "Москва", price = Price(2390)),
    )
    LazyRow {
        items(offers){offer ->
            val image = when (offer.id) {
                1  -> painterResource(R.drawable.ic_first)  // Replace with your actual resource IDs
                11  -> painterResource(R.drawable.ic_first)  // Replace with your actual resource IDs
                2 -> painterResource(R.drawable.ic_second)
                22 -> painterResource(R.drawable.ic_second)
                else -> painterResource(R.drawable.ic_third)
            }
            OfferItem(offer = offer, image = image)
        }
    }
}