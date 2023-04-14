package com.example.digikalacomposeproject.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.digikalacomposeproject.data.model.home.Slider
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.ui.theme.LocalShape
import com.example.digikalacomposeproject.ui.theme.LocalSpacing
import com.example.digikalacomposeproject.viewModel.HomeViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun TopSliderSection(viewModel: HomeViewModel = hiltViewModel()) {

    var sliderList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }

    var loading by remember {
        mutableStateOf(false)
    }

    val sliderResult by viewModel.slider.collectAsState()

    when (sliderResult) {
        is NetworkResult.Success -> {
            sliderList = sliderResult.data ?: emptyList()
            loading = false
        }
        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "Top Slider error : ${sliderResult.message}")
        }
        is NetworkResult.Loading -> {
            loading = true
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.White)
            .padding(
                horizontal = LocalSpacing.current.extraSmall,
                vertical = LocalSpacing.current.small
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(
                    horizontal = LocalSpacing.current.extraSmall,
                    vertical = LocalSpacing.current.small
                )
        ) {

            val pagerState = rememberPagerState()
            var imageUrl by remember {
                mutableStateOf("")
            }

            HorizontalPager(
                count = sliderList.size,
                state = pagerState,
                contentPadding = PaddingValues(horizontal = LocalSpacing.current.medium),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) { index ->
                imageUrl = sliderList[index].image
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
//use coil library:
                    val painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = imageUrl)
                            .apply(
                                block = fun ImageRequest.Builder.() {
                                    scale(Scale.FILL)
                                }
                            )
                            .build()
                    )
                    Image(
                        painter = painter, contentDescription = "", modifier = Modifier
                            .padding(LocalSpacing.current.small)
                            .clip(LocalShape.current.medium)
                            .fillMaxSize(),
                        contentScale = ContentScale.FillBounds
                    )

                    HorizontalPagerIndicator(
                        pagerState = pagerState,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(LocalSpacing.current.large),
                        activeColor = Color.Black,
                        inactiveColor = Color.LightGray,
                        indicatorWidth = LocalSpacing.current.small,
                        indicatorHeight = LocalSpacing.current.small,
                        indicatorShape = CircleShape
                    )

                }
            }

            LaunchedEffect(key1 = pagerState.currentPage) {
                delay(6000)
                var newPosition = pagerState.currentPage + 1
                if (newPosition > sliderList.size - 1) newPosition = 0
                pagerState.scrollToPage(newPosition)
            }
        }
    }
}


/**
 * 1- val sliderResult by viewModel.slider.collectAsState() --> actually define viewModel.slider as a state until
 * work to compose so better. so
 * we do not need to 1-LaunchedEffect(key1 = true) &&and&& 2-viewModel.slider.collectLatest {}
 *
 * 2- instead of writing like this: sliderList/data?.let{sliderList = it}  we can write better than:
 *    sliderList = sliderResult.data ?: emptyList()
 *
 * 3- elvis operator in kotlin -> ?: */


