package com.example.dota2stats.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.data.ProMatchRepositoryImpl
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(
    private val repository: ProMatchRepositoryImpl
    ): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}