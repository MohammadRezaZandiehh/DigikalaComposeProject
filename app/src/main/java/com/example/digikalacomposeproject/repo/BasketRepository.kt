package com.example.digikalacomposeproject.repo

import com.example.digikalacomposeproject.data.remote.BaseApiResponse
import com.example.digikalacomposeproject.data.remote.BasketApiInterface
import javax.inject.Inject

class BasketRepository @Inject constructor (private val api: BasketApiInterface): BaseApiResponse()  {

}