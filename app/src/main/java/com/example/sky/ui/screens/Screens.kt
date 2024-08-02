package com.example.sky.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.ListBestOffer

@Composable
fun HomeScreen(onClick: () -> Unit = {}){
    Column {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "Поиск дешевых\nавиабилетов",
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            maxLines = 2
        )
        DepartureField(modifier = Modifier)
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            text = "Музыкально отлететь",
            fontSize = 22.sp,
            maxLines = 1
        )
        ListBestOffer()
        Button(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            onClick = { /*TODO*/ }) {
                Text(text = "Показать все места")
            }
    }
}

@Composable
fun NextScreen(name: String?, age: Int){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$name, $age years old")
    }
}



@Composable
fun HotelScreen(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(text = "Hotels", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun InShortScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(text = " In Short Screen ", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun SubscribeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(text = "Subscribe Screen", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(text = "Profile Screen", fontSize = 24.sp, modifier = Modifier.padding(16.dp))
    }
}