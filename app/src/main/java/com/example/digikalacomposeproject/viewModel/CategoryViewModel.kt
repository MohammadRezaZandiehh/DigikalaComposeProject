package com.example.digikalacomposeproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalacomposeproject.data.model.category.SubCategory
import com.example.digikalacomposeproject.data.remote.NetworkResult
import com.example.digikalacomposeproject.repo.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) :
    ViewModel() {

    val subCategory = MutableStateFlow<NetworkResult<SubCategory>>(NetworkResult.Loading())


    suspend fun getAllDataFromServer() {
        viewModelScope.launch {

            //fire and forget
            launch {
                subCategory.emit(repository.getSubCategories())
            }
        }
    }
}