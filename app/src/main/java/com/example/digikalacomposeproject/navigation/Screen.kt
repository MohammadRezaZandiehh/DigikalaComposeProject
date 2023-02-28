package com.example.digikalacomposeproject.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
}