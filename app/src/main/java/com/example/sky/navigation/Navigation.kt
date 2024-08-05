package com.example.sky.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sky.ui.screens.HomeScreen
import com.example.sky.ui.screens.HotelScreen
import com.example.sky.ui.screens.InShortScreen
import com.example.sky.ui.screens.ProfileScreen
import com.example.sky.ui.screens.SubscribeScreen

@Composable
fun NavGraph(navController: NavHostController, modifier:Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "screenA"
    ) {
        composable("screenA") {
            HomeScreen(onClick = {
                navController.navigate("screenB")
            })
        }
        composable("screenB") {
            HotelScreen(onClick = { navController.navigate("screenA") })
        }
        composable("screenC") {
            InShortScreen()
        }
        composable("screenD") {
            SubscribeScreen()
        }
        composable("screenE") {
            ProfileScreen()
        }
    }
}