package com.example.dota2stats.presentation.proMatches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.data.RepositoryImpl
import javax.inject.Inject

class ProMatchesViewModelFactory @Inject constructor(
    private val repository: RepositoryImpl
    ): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProMatchesViewModel::class.java)) {
            return ProMatchesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}