package com.example.sky.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun DepartureField(modifier: Modifier = Modifier) {
    var textFrom by remember { mutableStateOf("Москва") }
    var textTo by remember { mutableStateOf(textFrom) }

    val currentContext = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        val sharedPreferences = currentContext.getSharedPreferences("app_pref", Context.MODE_PRIVATE)
        textFrom = sharedPreferences.getString("last_from_value", "Москва") ?: "Москва"
    }

    Surface(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp, // elevation for shadow
        color = MaterialTheme.colorScheme.surface
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = textFrom,
                    onValueChange = { string ->
                        if (string.all { char -> char.isLetter() && char !in 'A'..'Z' && char !in 'a'..'z' }) {
                            textFrom = string
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        val sharedPreferences = currentContext.getSharedPreferences("app_pref", Context.MODE_PRIVATE)
                        with(sharedPreferences.edit()) {
                            putString("last_from_value", textFrom)
                            apply()
                        }
                    }
                ),
                label = { Text("Откуда - Москва") }
                )
                TextField(
                    value = textTo,
                    onValueChange = { string ->
                        if (string.all { char -> char.isLetter() && char !in 'A'..'Z' && char !in 'a'..'z' }) {
                            textTo = string
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        val sharedPreferences = currentContext.getSharedPreferences("app_pref", Context.MODE_PRIVATE)
                        with(sharedPreferences.edit()) {
                            putString("last_to_value", textTo)
                            apply()
                        }
                    }
                ),
                label = { Text("Куда - Турция") }
                )
            }
        }
    }
}