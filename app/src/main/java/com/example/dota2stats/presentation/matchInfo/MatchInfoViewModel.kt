package com.example.dota2stats.presentation.matchInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2stats.domain.matchInfo.GetMatchInfoUseCase
import com.example.dota2stats.domain.matchInfo.InMatchPlayerItem
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.proMatches.ProMatchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchInfoViewModel(
    repository: ProMatchRepository,
    var matchId: Long = 0L
) : ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO)

    private val getMatchInfoUseCase = GetMatchInfoUseCase(repository)

    val players = MutableLiveData<List<InMatchPlayerItem>>()


    fun getPlayersList() {
        scope.launch {
            val match = getMatchInfoUseCase.getMatchInfo(matchId)
            players.postValue(match.players)
        }
    }
}