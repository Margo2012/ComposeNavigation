package com.example.sky.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.compose.rememberNavController
import com.example.sky.models.BottomNavItem
import com.example.sky.navigation.NavGraph

@Composable
fun MainScreen() {
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
            NavGraph(
                navController = navController,
                modifier = Modifier.padding(paddingValues))
        }
    }
}