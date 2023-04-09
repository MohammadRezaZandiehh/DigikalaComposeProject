package com.example.digikalacomposeproject.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digikalacomposeproject.navigation.Screen
import com.example.digikalacomposeproject.ui.theme.Purple200
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBarColor(navController: NavHostController) {
    val navABackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    when (navABackStackEntry?.destination?.route) {
        Screen.Splash.route -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Purple200
                )
            }
        }
        else -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.White
                )
            }
        }
    }
}



