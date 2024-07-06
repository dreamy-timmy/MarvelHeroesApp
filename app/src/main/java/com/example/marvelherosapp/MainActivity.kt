package com.example.marvelherosapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.marvelherosapp.HeroApp


import com.example.marvelherosapp.screens.MainScreen
import com.example.marvelherosapp.screens.DetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var isMainScreen by remember { mutableStateOf(true) }
            navController.addOnDestinationChangedListener { _, destination, _ ->
                isMainScreen = destination.route == "main"
            }

            HeroApp(isMainScreen) {

                NavHost(navController = navController, startDestination = "main") {
                    composable("main") { MainScreen(this@MainActivity, navController) }
                    composable("detail/{index}") { backStackEntry ->
                        val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
                        DetailScreen(this@MainActivity, navController, index)
                    }

                }

            }
        }
    }
}
