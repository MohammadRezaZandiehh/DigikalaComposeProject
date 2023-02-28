package com.example.digikalacomposeproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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