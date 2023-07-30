package com.example.digikalacomposeproject.viewModel

import androidx.lifecycle.ViewModel
import com.example.digikalacomposeproject.repo.BasketRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val api: BasketRepository) : ViewModel() {

}
