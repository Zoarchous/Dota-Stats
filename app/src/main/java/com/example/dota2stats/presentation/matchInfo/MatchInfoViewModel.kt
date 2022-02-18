package com.example.dota2stats.presentation.matchInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.domain.matchInfo.GetMatchInfoUseCase
import com.example.dota2stats.domain.matchInfo.InMatchPlayerItem
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchInfoViewModel(
    repository: Repository,
    var matchId: Long = 0L
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.IO)

    private val getMatchInfoUseCase = GetMatchInfoUseCase(repository)

    val players = MutableLiveData<List<InMatchPlayerItem>>()

    val matchItem = MutableLiveData<MatchItem>()


    fun getPlayersList() {
        viewModelScope.launch {
            val match = getMatchInfoUseCase.getMatchInfo(matchId)
            matchItem.value = match
            players.postValue(match.players)
        }
    }




}