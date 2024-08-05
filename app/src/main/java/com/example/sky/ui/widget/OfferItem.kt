package com.example.sky.ui.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.models.BestOffer


@Composable
fun OfferItem(offer: BestOffer, image: Painter?) {
    Column(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            if (image != null) {
                Image(
                    modifier = Modifier,
                    painter = image,
                    contentDescription = null,
                )
            }
        }
        Text(
            text = offer.title,
            fontSize = 20.sp,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
        Text(text = offer.town, fontSize = 16.sp, modifier = Modifier.padding(bottom = 4.dp))
        Text(text = formatPrice(offer.price.value), fontSize = 18.sp)
    }

}



private fun formatPrice(price: Int): String {
    return "%,d".format(price).replace(",", " ")
}

