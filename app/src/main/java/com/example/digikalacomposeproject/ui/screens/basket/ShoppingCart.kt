package com.example.digikalacomposeproject.ui.screens.basket

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingCart() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth()
            .padding(bottom = 60.dp)
    ) {
        item { EmptyBasketShopping() }
        item { SuggestListSection() }
    }
}






