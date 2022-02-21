package com.example.dota2stats.presentation.proPlayers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.proPlayers.GetProPlayersListUseCase
import com.example.dota2stats.domain.proPlayers.ProPlayersItem
import kotlinx.coroutines.launch

class ProPlayersViewModel(
    repository: Repository
): ViewModel() {
    private val getProPlayersListUseCase = GetProPlayersListUseCase(repository)

    val players = MutableLiveData<MutableList<ProPlayersItem>>()

    fun getProPlayers(){
        viewModelScope.launch {
            players.postValue(getProPlayersListUseCase.getProPlayers())
        }
    }
}