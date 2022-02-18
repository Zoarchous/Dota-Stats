package com.example.dota2stats.presentation.playersSearch

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.playersSearch.PlayerSearchItem
import com.example.dota2stats.domain.playersSearch.SearchPlayersUseCase
import kotlinx.coroutines.launch

class PlayerSearchViewModel(
    repository: Repository,
    var nickname: String = ""
): ViewModel() {
    private val searchPlayersUseCase = SearchPlayersUseCase(repository)

    val players = MutableLiveData<MutableList<PlayerSearchItem>>()

    fun getPlayers(){
        viewModelScope.launch {
            val data = searchPlayersUseCase.searchPlayers(nickname)
            players.postValue(data)
        }
    }
}