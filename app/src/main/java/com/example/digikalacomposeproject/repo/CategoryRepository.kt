package com.example.digikalacomposeproject.repo

import com.example.digikalacomposeproject.data.model.category.SubCategory
import com.example.digikalacomposeproject.data.remote.BaseApiResponse
import com.example.digikalacomposeproject.data.remote.CategoryApiInterface
import com.example.digikalacomposeproject.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val api: CategoryApiInterface
) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }

}