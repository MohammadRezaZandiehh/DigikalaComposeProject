package com.example.digikalacomposeproject.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.digikalacomposeproject.data.model.home.MainCategory
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.ui.theme.spacing
import com.example.digikalacomposeproject.viewModel.HomeViewModel
import com.example.digikalacomposeproject.R
import com.example.digikalacomposeproject.ui.theme.darkText


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryListSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var categoryList by remember {
        mutableStateOf<List<MainCategory>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }

    val categoryResult by viewModel.categories.collectAsState()
    when (categoryResult) {
        is NetworkResult.Success -> {
            categoryList = categoryResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "CategoryListSection error : ${categoryResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(MaterialTheme.spacing.small)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.medium),
            text = stringResource(id = R.string.category_title),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
        )

        FlowRow(
            horizontalArrangement = Arrangement.SpaceBetween,
            maxItemsInEachRow = 3,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            for (item in categoryList) {
                CircularCategoryItem(item)
            }
        }
    }

}

@Composable
fun CircularCategoryItem(item: MainCategory) {
    Column(
        modifier = Modifier.size(100.dp, 160.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = rememberAsyncImagePainter(item.image),
            contentDescription = "",
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(vertical = MaterialTheme.spacing.extraSmall)
        )

        Text(
            text = item.name,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = MaterialTheme.spacing.extraSmall),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}