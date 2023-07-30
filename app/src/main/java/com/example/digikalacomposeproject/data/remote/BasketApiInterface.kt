package com.example.digikalacomposeproject.data.remote

import com.example.digikalacomposeproject.data.model.ResponseResult
import com.example.digikalacomposeproject.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET


interface BasketApiInterface {

    @GET("v1/getAllProducts")
    suspend fun getSuggestionItem(): Response<ResponseResult<List<StoreProduct>>>

}