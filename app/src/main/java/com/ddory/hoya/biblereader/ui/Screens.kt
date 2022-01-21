package com.ddory.hoya.biblereader.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainScreen(
    val icon: ImageVector
) {
    Home(Icons.Outlined.Home),
    Friends(Icons.Outlined.Person),
    Settings(Icons.Outlined.Settings);

    companion object {
        fun fromRoute(route: String?): MainScreen =
            when (route?.substringBefore("/")) {
                Home.name -> Home
                Friends.name -> Friends
                Settings.name -> Settings
                null -> Home
                else -> throw IllegalArgumentException("Route $route is not recognized.")
            }
    }
}
