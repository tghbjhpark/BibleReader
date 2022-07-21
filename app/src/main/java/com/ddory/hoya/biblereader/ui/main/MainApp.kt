package com.ddory.hoya.biblereader.ui.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ddory.hoya.biblereader.ui.MainScreen

@Composable
fun MainApp() {
    MaterialTheme {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavigation {
                    BottomNavigationItem(
                        icon = { Icon(MainScreen.Home.icon, null) },
                        selected = false,
                        onClick = { navController.navigate(MainScreen.Home.name) }
                    )
                    BottomNavigationItem(
                        icon = { Icon(MainScreen.Friends.icon, null) },
                        selected = false,
                        onClick = { navController.navigate(MainScreen.Friends.name) }
                    )
                    BottomNavigationItem(
                        icon = { Icon(MainScreen.Settings.icon, null) },
                        selected = false,
                        onClick = { navController.navigate(MainScreen.Settings.name) }
                    )
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = MainScreen.Home.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(MainScreen.Home.name) {
                   Text(text = "home")
                }
                composable(MainScreen.Friends.name) {
                    Text(text = "friends")
                }
                composable(MainScreen.Settings.name) {
                    Text(text = "settings")
                }
            }
        }
    }
}