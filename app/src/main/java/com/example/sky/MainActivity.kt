package com.example.sky

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Button
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sky.models.BestOffer
import com.example.sky.models.BottomNavItem
import com.example.sky.models.Price
import com.example.sky.ui.screens.DepartureField
import com.example.sky.ui.theme.SkyTheme
import com.example.sky.ui.widget.OfferItem


@Composable
fun ListBestOffer() {
    val offers = listOf(
        BestOffer(id = 1, title = "Die Antwoord", town = "Будапешт", price = Price(5000)),
        BestOffer(id = 2, title = "Socrat&Lera", town = "Санкт-Петербург", price = Price(1999)),
        BestOffer(id = 3, title = "Лампабикт", town = "Москва", price = Price(2390)),
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
                        title = "Авиабилеты",
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
                                        onClick = { selectedItemIndex = index },
                                        label = { Text(text = item.title)},
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
                    ) {
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
                    /*val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenA
                    ){
                        composable<ScreenA> {
                            HomeScreen(onClick = {navController.navigate(ScreenB(
                                name = null,
                                age = 25
                            ))})
                        }

                        composable<ScreenB>{
                            val args = it.toRoute<ScreenB>()
                            NextScreen(args.name, args.age)
                        }
                    }*/


                }
            }
        }
    }
}

