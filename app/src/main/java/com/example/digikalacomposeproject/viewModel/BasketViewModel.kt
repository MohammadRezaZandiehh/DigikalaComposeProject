package com.example.digikalacomposeproject.viewModel

import android.app.admin.NetworkEvent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalacomposeproject.data.model.basket.CartItem
import com.example.digikalacomposeproject.data.model.home.StoreProduct
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.repo.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(
    private val repository: BasketRepository
) : ViewModel() {

    val suggestedList = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())

    fun getSuggestionItem() {
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestionList())
        }
    }

    fun insertCartItem(cart: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCartItem(cart)
        }
    }
}
