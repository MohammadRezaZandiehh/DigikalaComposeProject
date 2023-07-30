package com.example.digikalacomposeproject.ui.screens.category

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikalacomposeproject.data.model.category.Sub
import com.example.digikalacomposeproject.R
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.ui.components.OurLoading
import com.example.digikalacomposeproject.viewModel.CategoryViewModel

@Composable
fun SubCategorySection(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    var toolList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var digitalList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var mobileList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var fashionList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var nativeList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var toyList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var homeList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var bookList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var sportList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var supermarketList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var beautyList by remember {
        mutableStateOf<List<Sub>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val subCategoryItemResult by viewModel.subCategory.collectAsState()
    when (subCategoryItemResult) {
        is NetworkResult.Success -> {
            subCategoryItemResult.data?.let {
                toolList = it.tool
                digitalList = it.digital
                mobileList = it.mobile
                fashionList = it.fashion
                nativeList = it.native
                bookList = it.book
                homeList = it.home
                sportList = it.sport
                supermarketList = it.supermarket
                beautyList = it.beauty
                toyList = it.toy
            }
            loading = false
        }

        is NetworkResult.Error -> {
            Log.e("3636", "AmazingOfferSection error : ${subCategoryItemResult.message}")
            loading = false
        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }

    if (loading) {
        val config = LocalConfiguration.current
        OurLoading(height = config.screenHeightDp.dp, isDark = true)
    } else {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            CategoryItem(
                stringResource(id = R.string.industrial_tools_and_equipment),
                toolList
            )
            CategoryItem(
                title = stringResource(id = R.string.digital_goods),
                subList = digitalList
            )
            CategoryItem(
                title = stringResource(id = R.string.mobile),
                subList = mobileList
            )
            CategoryItem(
                title = stringResource(id = R.string.fashion_and_clothing),
                subList = fashionList
            )
            CategoryItem(
                title = stringResource(id = R.string.supermarket_product),
                subList = supermarketList
            )
            CategoryItem(
                title = stringResource(id = R.string.native_and_local_products),
                subList = nativeList
            )
            CategoryItem(
                title = stringResource(id = R.string.toys_children_and_babies),
                subList = toyList
            )
            CategoryItem(
                title = stringResource(id = R.string.beauty_and_health),
                subList = beautyList
            )
            CategoryItem(
                title = stringResource(id = R.string.home_and_kitchen),
                subList = homeList
            )
            CategoryItem(
                title = stringResource(id = R.string.books_and_stationery),
                subList = bookList
            )
            CategoryItem(
                title = stringResource(id = R.string.sports_and_travel),
                subList = sportList
            )
        }
    }
}





