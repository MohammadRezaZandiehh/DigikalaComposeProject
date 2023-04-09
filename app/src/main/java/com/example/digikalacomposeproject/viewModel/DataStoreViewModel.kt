package com.example.digikalacomposeproject.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikalacomposeproject.data.dataStore.DataStoreRepository
import com.example.digikalacomposeproject.util.Constants.PERSIAN_LANG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {


    companion object {
        const val USER_LANGUAGE_KEY = "USER_LANGUAGE_KEY"
    }

    fun saveUserLanguage(value: String) {
        viewModelScope.launch {
            repository.putString(USER_LANGUAGE_KEY, value)
        }
    }

    fun getUserLanguage(): String = runBlocking {
        repository.getString(USER_LANGUAGE_KEY) ?: PERSIAN_LANG
    }
}

/** we told we can use to data store in 3 ways and one of the was runBlocking
 * here it is offered that use runBlocking because we want to use language and it is a config.
 * so we know that when we use runBlocking it block ui and functionalities after that will do other functionalities
 * and we want to set ot get language first of all functionalities :) */