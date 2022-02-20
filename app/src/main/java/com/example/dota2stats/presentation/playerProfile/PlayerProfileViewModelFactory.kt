package com.example.dota2stats.presentation.playerProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.data.RepositoryImpl
import com.example.dota2stats.presentation.matchInfo.MatchInfoViewModel
import javax.inject.Inject


class PlayerProfileViewModelFactory @Inject constructor(
    private val repository: RepositoryImpl
): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom( PlayerProfileViewModel::class.java)) {
            return  PlayerProfileViewModel (repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}