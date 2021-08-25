package com.ddory.hoya.biblereader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import com.ddory.hoya.biblereader.ui.ActivityViewModel
import com.ddory.hoya.biblereader.ui.splash.SplashScreen

class MainActivity : AppCompatActivity() {

    private val viewModel: ActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }

    @Composable
    fun MainApp() {
        MaterialTheme {
            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        BottomNavigationItem(
                            icon = { Icon(Icons.Outlined.Home, contentDescription = null) },
                            label = { Text("Home")},
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Outlined.Person, contentDescription = null) },
                            label = { Text("Friends")},
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                        BottomNavigationItem(
                            icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                            label = { Text("Settings")},
                            selected = false,
                            onClick = { /*TODO*/ }
                        )
                    }
                }
            ) {
                SplashScreen()
            }
        }
    }
}
