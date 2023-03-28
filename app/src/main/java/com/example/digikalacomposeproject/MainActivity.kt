package com.example.digikalacomposeproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digikalacomposeproject.navigation.SetupNavGraph
import com.example.digikalacomposeproject.ui.theme.DigikalaComposeProjectTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaComposeProjectTheme {
                navController = rememberNavController()

                Scaffold(
                    bottomBar ={
                        //Todo
                    }
                ) {
                    SetupNavGraph(navController = navController)
                }
            }
        }
    }
}