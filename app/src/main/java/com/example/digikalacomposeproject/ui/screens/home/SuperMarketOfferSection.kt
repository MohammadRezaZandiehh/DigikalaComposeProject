package com.example.digikalacomposeproject.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalacomposeproject.data.model.home.AmazingItem
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.ui.theme.DigikalaLightGreen
import com.example.digikalacomposeproject.ui.theme.DigikalaLightRed
import com.example.digikalacomposeproject.viewModel.HomeViewModel
import com.example.digikalacomposeproject.R

@Composable
fun SuperMarketOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var superMarketItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val superMarketItemResult by viewModel.superMarketItems.collectAsState()
    when (superMarketItemResult) {
        is NetworkResult.Success -> {
            superMarketItemList = superMarketItemResult.data ?: emptyList()
            loading = false
            Log.e("3636", "item: ${superMarketItemList[0].name}")
        }
        is NetworkResult.Error -> {
            Log.e("3636", "superMarketOfferSection error : ${superMarketItemResult.message}")
            loading = false
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.DigikalaLightRed)
    ) {
        LazyRow(modifier = Modifier.background(MaterialTheme.colors.DigikalaLightGreen)) {

            item {
                AmazingOfferCard(R.drawable.supermarketamazings, R.drawable.fresh)
            }

            items(superMarketItemList) { item ->
                AmazingItem(item = item)
            }

            item {
                AmazingShowMoreItem()
            }
        }
    }
}








