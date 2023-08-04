package com.example.digikalacomposeproject.repo

import com.example.digikalacomposeproject.data.db.CartDao
import com.example.digikalacomposeproject.data.model.basket.CartItem
import com.example.digikalacomposeproject.data.model.basket.CartStatus
import com.example.digikalacomposeproject.data.model.home.StoreProduct
import com.example.digikalacomposeproject.data.remote.BaseApiResponse
import com.example.digikalacomposeproject.data.remote.BasketApiInterface
import com.example.digikalacomposeproject.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val dao: CartDao
) :
    BaseApiResponse() {

    val currentCartItems = dao.getAllItems(CartStatus.CURRENT_CART)

    suspend fun getSuggestionList(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestionItem()
        }

    suspend fun insertCartItem(cart: CartItem) {
        dao.insertCartItem(cart)
    }

    suspend fun removeFromCart(cart: CartItem) {
        dao.removeFromCart(cart)
    }

    suspend fun changeCartItemCount(id: String, newCount: Int) {
        dao.changeCountCartItem(id, newCount)
    }

    suspend fun changeCartItemStatus(id: String, newStatus: CartStatus) {
        dao.changeStatusCart(id, newStatus)
    }
}