package com.example.digikalacomposeproject.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.digikalacomposeproject.R
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digikalacomposeproject.ui.theme.selectedBottomBar
import com.example.digikalacomposeproject.ui.theme.unSelectedBottomBar

@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem(
            name = "خانه",
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.home_fill),
            unSelectedIcon = painterResource(id = R.drawable.home_outline)
        ),
        BottomNavItem(
            name = "دسته بندی",
            route = Screen.Category.route,
            selectedIcon = painterResource(id = R.drawable.category_fill),
            unSelectedIcon = painterResource(id = R.drawable.category_outline)
        ),
        BottomNavItem(
            name = "سبد خرید",
            route = Screen.Basket.route,
            selectedIcon = painterResource(id = R.drawable.cart_fill),
            unSelectedIcon = painterResource(id = R.drawable.cart_outline)
        ),
        BottomNavItem(
            name = "پروفایل",
            route = Screen.Profile.route,
            selectedIcon = painterResource(id = R.drawable.user_fill),
            unSelectedIcon = painterResource(id = R.drawable.user_outline)
        )
    )

    //condition of showing the bottomNavigation (e.g: where we should show or not):
    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }

    if (showBottomBar) {
        BottomNavigation(
            modifier = modifier,
            backgroundColor = Color.White,
            elevation = 5.dp
        ) {
            items.forEachIndexed { index, item ->
                //we want to find that current item is selected or not
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colors.unSelectedBottomBar,
                    icon = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            if (selected) {
                                Icon(
                                    painter = item.selectedIcon,
                                    contentDescription = item.name,
                                    modifier = Modifier.height(24.dp)
                                )
                            } else {
                                Icon(
                                    painter = item.unSelectedIcon,
                                    contentDescription = item.name,
                                    modifier = Modifier.height(24.dp)
                                )
                            }
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }
                    }
                )
            }
        }
    } else {

    }
}

/**
 * ?? what is the difference between navHostController and navController in compose ??
 * The NavHost is the container that holds all of the navigation destinations within the app.
 * The NavController is responsible for managing the navigation between different destinations and
 * the Navigation composable is used to declare a specific destination within the NavHost
 *
 * onItemClick: (BottomNavItem) -> Unit ??? --> one fun which its input is BottomNavItem and return nothing (Unit)
 * and we pass this fun in main activity.
 *
 * ******** backStackEntry.value?.destination?.route ************: ---> get us the current rout <----
 * val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.route }:
 * if the current rout is in my items, the current page should
 * show the bottomNavigation
 *
 * */