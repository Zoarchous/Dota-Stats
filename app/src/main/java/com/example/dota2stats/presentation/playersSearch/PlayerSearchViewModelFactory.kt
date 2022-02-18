package com.example.dota2stats.presentation.playersSearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.data.RepositoryImpl
import com.example.dota2stats.presentation.matchInfo.MatchInfoViewModel
import javax.inject.Inject

class PlayerSearchViewModelFactory @Inject constructor(
    private val repository: RepositoryImpl
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerSearchViewModel::class.java)) {
            return PlayerSearchViewModel (repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}