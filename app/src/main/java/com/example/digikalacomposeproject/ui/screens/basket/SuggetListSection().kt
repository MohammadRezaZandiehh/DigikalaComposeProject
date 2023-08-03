package com.example.digikalacomposeproject.ui.screens.basket

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalacomposeproject.data.model.home.StoreProduct
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.ui.theme.darkText
import com.example.digikalacomposeproject.ui.theme.searchBarBg
import com.example.digikalacomposeproject.ui.theme.spacing
import com.example.digikalacomposeproject.viewModel.BasketViewModel
import com.example.digikalacomposeproject.R
import com.example.digikalacomposeproject.data.model.basket.CartItem
import com.example.digikalacomposeproject.data.model.basket.CartStatus
import com.example.digikalacomposeproject.ui.screens.category.SuggestionItemCard
import com.example.digikalacomposeproject.ui.screens.home.MostDiscountedCard

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SuggestListSection(
    viewModel: BasketViewModel = hiltViewModel()
) {

    viewModel.getSuggestionItem()

    var suggestedList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val suggestedItemResult by viewModel.suggestedList.collectAsState()
    when (suggestedItemResult) {
        is NetworkResult.Success -> {
            suggestedList = suggestedItemResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "SuggestListSection error : ${suggestedItemResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.spacing.small)
            .background(MaterialTheme.colors.searchBarBg)
    )

    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.medium),
        text = stringResource(id = R.string.suggestion_for_you),
        textAlign = TextAlign.Right,
        style = MaterialTheme.typography.h4,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colors.darkText,
    )

    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.Start
    ) {

        for (item in suggestedList) {
            SuggestionItemCard(item){
                viewModel.insertCartItem(
                    CartItem(
                        itemId = it._id,
                        name = it.name,
                        seller = it.seller,
                        price = it.price,
                        discountPercent = it.discountPercent,
                        image = it.image,
                        1,
                        cartStatus = CartStatus.CURRENT_CART
                    )
                )
            }
        }
    }
}