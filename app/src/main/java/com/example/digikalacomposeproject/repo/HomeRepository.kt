package com.example.digikalacomposeproject.repo

import com.example.digikalacomposeproject.data.model.home.Slider
import com.example.digikalacomposeproject.data.remote.BaseApiResponse
import com.example.digikalacomposeproject.data.remote.HomeApiInterface
import com.example.digikalacomposeproject.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeApiInterface: HomeApiInterface
) : BaseApiResponse() {
    suspend fun getSlider():NetworkResult<List<Slider>> = safeApiCall {
        homeApiInterface.getSlider()
    }
}