package com.example.digikalacomposeproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digikalacomposeproject.navigation.BottomNavigationBar
import com.example.digikalacomposeproject.navigation.SetupNavGraph
import com.example.digikalacomposeproject.ui.components.AppConfig
import com.example.digikalacomposeproject.ui.theme.DigikalaComposeProjectTheme
import com.example.digikalacomposeproject.util.Constants
import com.example.digikalacomposeproject.util.Constants.ENGLISH_LANG
import com.example.digikalacomposeproject.util.Constants.PERSIAN_LANG
import com.example.digikalacomposeproject.util.Constants.USER_LANGUAGE
import com.example.digikalacomposeproject.util.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigikalaComposeProjectTheme {
                navController = rememberNavController()

                AppConfig()
                Log.e("3636", USER_LANGUAGE)

                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)

                val direction = if (USER_LANGUAGE == ENGLISH_LANG) {
                    LayoutDirection.Ltr
                } else {
                    LayoutDirection.Rtl
                }

                CompositionLocalProvider(LocalLayoutDirection provides direction) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                })
                        }
                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}

/**
 * navController.navigate(it.route) --> when you click on each item, go navigate on it item! (by its rout)*/