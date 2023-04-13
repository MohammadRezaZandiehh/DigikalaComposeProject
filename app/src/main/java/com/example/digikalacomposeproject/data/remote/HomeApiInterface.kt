package com.example.digikalacomposeproject.data.remote

import com.example.digikalacomposeproject.data.model.ResponseResult
import com.example.digikalacomposeproject.data.model.home.Slider
import retrofit2.Response
import retrofit2.http.GET

interface HomeApiInterface {

    @GET("v1/getSlider")
    suspend fun getSlider(): Response<ResponseResult<List<Slider>>>
}