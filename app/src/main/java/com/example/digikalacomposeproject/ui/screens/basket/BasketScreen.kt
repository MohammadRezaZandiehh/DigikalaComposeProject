package com.example.digikalacomposeproject.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikalacomposeproject.viewModel.BasketViewModel
import com.example.digikalacomposeproject.R
import com.example.digikalacomposeproject.ui.theme.digikalaRed
import com.example.digikalacomposeproject.ui.theme.spacing

@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(navController = navController)
}

@Composable
fun Basket(
    navController: NavHostController,
    viewModel: BasketViewModel = hiltViewModel()
) {
    var selectedTabState by remember {
        mutableStateOf(0)
    }

    val tabTitles = listOf(
        stringResource(id = R.string.cart),
        stringResource(id = R.string.next_cart_list)
    )
    Column {
        TabRow(
            modifier = Modifier
                .padding(horizontal = MaterialTheme.spacing.medium),
            selectedTabIndex = selectedTabState,
            contentColor = MaterialTheme.colors.digikalaRed,
            backgroundColor = Color.White,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[selectedTabState])
                        .height(3.dp)
                        .background(Color.Red)
                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabState == index,
                    onClick = {
                        selectedTabState = index
                    },
                    selectedContentColor = MaterialTheme.colors.digikalaRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                )
            }
        }

        when (selectedTabState) {
            0 -> ShoppingCart()
            1 -> NextShoppingList()
        }
    }
}

/**
 * .tabIndicatorOffset(line[selectedTabState]) --> az dakhele array e line item e shomare
 * selected shode ro peyda kon ----> dar vaghe line ye array hast.
 */