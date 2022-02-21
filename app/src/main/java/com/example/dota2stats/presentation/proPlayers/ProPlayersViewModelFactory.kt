package com.example.dota2stats.presentation.proPlayers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.data.RepositoryImpl
import com.example.dota2stats.presentation.playersSearch.PlayerSearchViewModel
import javax.inject.Inject

class ProPlayersViewModelFactory @Inject constructor(
    private val repository: RepositoryImpl
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProPlayersViewModel::class.java)) {
            return ProPlayersViewModel (repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}