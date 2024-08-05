package com.example.sky.ui.dialogs

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable


@Composable
fun ComplexRouteDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Сложный маршрут") },
        text = { Text(text = "Заглушка для сложного маршрута") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text(text = "Закрыть")
            }
        }
    )
}

@Composable
fun WeekendsDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Выходные") },
        text = { Text(text = "Заглушка для выходных") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text(text = "Закрыть")
            }
        }
    )
}

@Composable
fun HotTicketsDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Горящие билеты") },
        text = { Text(text = "Заглушка для горящих билетов") },
        confirmButton = {
            Button(onClick = onDismiss) {
                Text(text = "Закрыть")
            }
        }
    )
}