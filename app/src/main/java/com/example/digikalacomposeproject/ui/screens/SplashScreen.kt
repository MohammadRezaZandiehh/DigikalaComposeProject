package com.example.digikalacomposeproject.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.digikalacomposeproject.ui.theme.splashBg
import com.example.digikalacomposeproject.R
import com.example.digikalacomposeproject.navigation.Screen
import com.example.digikalacomposeproject.ui.components.Loading3Dots
import kotlinx.coroutines.delay
import okhttp3.internal.notify

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()
    LaunchedEffect(true) {
        delay(2500)
        navController.navigate(Screen.Home.route)
    }

}

@Preview
@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.splashBg)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier.size(250.dp),
                painter = painterResource(id = R.drawable.digi_logo),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(100.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                modifier = Modifier.height(30.dp),
                painter = painterResource(id = R.drawable.digi_txt_white),
                contentDescription = null
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Loading3Dots(false)
        }
    }
}