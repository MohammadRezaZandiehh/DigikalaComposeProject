package com.example.digikalacomposeproject.repo

import com.example.digikalacomposeproject.data.model.home.AmazingItem
import com.example.digikalacomposeproject.data.model.home.MainCategory
import com.example.digikalacomposeproject.data.model.home.Slider
import com.example.digikalacomposeproject.data.model.home.StoreProduct
import com.example.digikalacomposeproject.data.remote.BaseApiResponse
import com.example.digikalacomposeproject.data.remote.HomeApiInterface
import com.example.digikalacomposeproject.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeApiInterface: HomeApiInterface
) : BaseApiResponse() {
    suspend fun getSlider(): NetworkResult<List<Slider>> = safeApiCall {
        homeApiInterface.getSlider()
    }

    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> = safeApiCall {
        homeApiInterface.getAmazingItems()
    }

    suspend fun getAmazingSuperMarketItems(): NetworkResult<List<AmazingItem>> = safeApiCall {
        homeApiInterface.getAmazingSuperMarketItems()
    }

    suspend fun getProposalBanners(): NetworkResult<List<Slider>> = safeApiCall {
        homeApiInterface.getProposalBanners()
    }

    suspend fun getCategories(): NetworkResult<List<MainCategory>> = safeApiCall {
        homeApiInterface.getCategories()
    }

    suspend fun getCenterBanners(): NetworkResult<List<Slider>> =
        safeApiCall {
            homeApiInterface.getCenterBanners()
        }

    suspend fun getBestSellerItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            homeApiInterface.getBestSellerItems()
        }

    suspend fun getMostVisitedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            homeApiInterface.getMostVisitedItems()
        }

    suspend fun getMostFavoriteItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            homeApiInterface.getMostFavoriteItems()
        }

}