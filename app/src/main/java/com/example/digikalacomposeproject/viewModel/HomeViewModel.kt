package com.example.digikalacomposeproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalacomposeproject.data.model.home.Slider
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.repo.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    val slider = MutableStateFlow<NetworkResult<List<Slider>>>(NetworkResult.Loading())

    suspend fun getSlider() {
        viewModelScope.launch {
            slider.emit(repository.getSlider())
        }
    }
}