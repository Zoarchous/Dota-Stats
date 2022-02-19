package com.example.dota2stats.presentation.matchInfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.data.remoteModel.IMAGE_URL
import com.example.dota2stats.domain.matchInfo.GetMatchInfoUseCase
import com.example.dota2stats.domain.matchInfo.InMatchPlayerItem
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.constants.GetHeroesListUseCase
import com.example.dota2stats.domain.constants.Hero
import com.example.dota2stats.findHero
import kotlinx.coroutines.launch

class MatchInfoViewModel(
    repository: Repository,
    var matchId: Long = 0L
) : ViewModel() {


    private val getMatchInfoUseCase = GetMatchInfoUseCase(repository)

    private val getHeroesListUseCase = GetHeroesListUseCase(repository)

    val players = MutableLiveData<List<InMatchPlayerItem>>()

    val matchItem = MutableLiveData<MatchItem>()

    val heroesList = MutableLiveData<MutableList<Hero>>()


    fun getPlayersList() {
        viewModelScope.launch {
            val heroes = getHeroesListUseCase.getHeroes()
            val match = getMatchInfoUseCase.getMatchInfo(matchId)
            heroesList.postValue(heroes)
            matchItem.value = match
            players.postValue(match.players)
        }
    }

    fun getHero(position: Int): String? {
        val heroPosition = findHero(position)
        val img = heroesList.value?.get(heroPosition)?.icon
        return IMAGE_URL + img

    }

}