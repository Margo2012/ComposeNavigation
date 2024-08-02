package com.example.sky

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sky.models.BestOffer
import com.example.sky.models.BottomNavItem
import com.example.sky.models.Price
import com.example.sky.ui.screens.HomeScreen
import com.example.sky.ui.screens.HotelScreen
import com.example.sky.ui.screens.InShortScreen
import com.example.sky.ui.screens.SubscribeScreen
import com.example.sky.ui.screens.ProfileScreen
import com.example.sky.ui.theme.SkyTheme
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
          /*val image = when (offer.id) {
              1 -> painterResource(R.drawable.image1)  // Replace with your actual resource IDs
              2 -> painterResource(R.drawable.image2)
              else -> painterResource(R.drawable.image3)
          }*/
          OfferItem(offer = offer, image = null)
      }
    }
}

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkyTheme {
                val items = listOf(
                    BottomNavItem(
                        title = "Билеты",
                        selectedIcon = Icons.Filled.Send,
                        unselectedIcon = Icons.Outlined.Send
                    ),
                    BottomNavItem(
                        title = "Отели",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home
                    ),
                    BottomNavItem(
                        title = "Короче",
                        selectedIcon = Icons.Filled.LocationOn,
                        unselectedIcon = Icons.Outlined.LocationOn
                    ),
                    BottomNavItem(
                        title = "Поделиться",
                        selectedIcon = Icons.Filled.Notifications,
                        unselectedIcon = Icons.Outlined.Notifications
                    ),
                    BottomNavItem(
                        title = "Профиль",
                        selectedIcon = Icons.Filled.Person,
                        unselectedIcon = Icons.Outlined.Person
                    )
                )
                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            when (index) {
                                                0 -> navController.navigate("screenA")
                                                1 -> navController.navigate("screenB")
                                                2 -> navController.navigate("screenC")
                                                3 -> navController.navigate("screenD")
                                                4 -> navController.navigate("screenE")
                                            }
                                        },
                                        label = { Text(text = item.title) },
                                        icon = {
                                            Icon(
                                                imageVector = if (selectedItemIndex == index)
                                                    item.selectedIcon
                                                else
                                                    item.unselectedIcon,
                                                contentDescription = item.title
                                            )
                                        })
                                }
                            }
                        }
                    ) { paddingValues ->
                        NavHost(
                            navController = navController,
                            startDestination = "screenA",
                            modifier = Modifier.padding(paddingValues)
                        ) {
                            composable("screenA") {
                                HomeScreen(onClick = {
                                    navController.navigate(
                                        "screenB"
                                    )
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
                }
            }
        }
    }
}

