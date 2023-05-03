package com.example.digikalacomposeproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalacomposeproject.data.model.home.AmazingItem
import com.example.digikalacomposeproject.data.model.home.Slider
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.repo.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())
    val amazingItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())
    val superMarketItems = MutableStateFlow<NetworkResult<List<AmazingItem>>>(NetworkResult.Loading())

    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

//fire and forget:
            launch {
                slider.emit(repository.getSlider())
            }

            launch {
                amazingItems.emit(repository.getAmazingItems())
            }

            launch {
                superMarketItems.emit(repository.getAmazingSuperMarketItems())
            }
        }
    }
}

/**
 * fire and forget: when we have some apiCall that they do not depend together, we should use this design pattern
 * to increase the speed of calling apis "call apis in the most speed condition".
 * we should attention if apis depend together we should use Async $$ Await*/