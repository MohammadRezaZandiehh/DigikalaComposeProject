package com.example.digikalacomposeproject.viewModel

import androidx.lifecycle.ViewModel

class BaseViewModel: ViewModel() {
    private suspend fun refreshDataFromServer(viewModel: HomeViewModel) {
        viewModel.getAllDataFromServer()
    }
}