package com.example.dota2stats.presentation

import androidx.lifecycle.ViewModel
import com.example.dota2stats.data.ProMatchRepositoryImpl
import com.example.dota2stats.domain.proMatches.GetProMatchItemUseCase
import com.example.dota2stats.domain.proMatches.GetProMatchesListUseCase

class MainViewModel: ViewModel() {
    private val repository = ProMatchRepositoryImpl

    private val getProMatchItemUseCase = GetProMatchItemUseCase(repository)
    private val getProMatchesListUseCase = GetProMatchesListUseCase(repository)

    val proMatchList = getProMatchesListUseCase.getProMatchesList()
}