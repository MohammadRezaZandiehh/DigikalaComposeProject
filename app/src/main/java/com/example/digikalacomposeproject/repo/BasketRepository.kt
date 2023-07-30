package com.example.digikalacomposeproject.repo

import com.example.digikalacomposeproject.data.model.home.StoreProduct
import com.example.digikalacomposeproject.data.remote.BaseApiResponse
import com.example.digikalacomposeproject.data.remote.BasketApiInterface
import com.example.digikalacomposeproject.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor (private val api: BasketApiInterface): BaseApiResponse()  {

    suspend fun getSuggestionList(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestionItem()
        }
}