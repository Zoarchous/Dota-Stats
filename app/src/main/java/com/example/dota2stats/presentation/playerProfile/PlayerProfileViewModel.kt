package com.example.dota2stats.presentation.playerProfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.data.remoteModel.IMAGE_URL
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.constants.GetHeroesListUseCase
import com.example.dota2stats.domain.constants.Hero
import com.example.dota2stats.domain.playerProfile.*
import com.example.dota2stats.findHero
import kotlinx.coroutines.launch

class PlayerProfileViewModel(
    repository: Repository,
    var account_id: Int = 0
) : ViewModel() {
    private val getPlayerProfileUseCase = GetPlayerProfileUseCase(repository)
    private val getRecentMatchesUseCase = GetRecentMatchesUseCase(repository)
    private val getWinrateUseCase = GetWinrateUseCase(repository)
    private val getHeroesListUseCase = GetHeroesListUseCase(repository)

    var profile = MutableLiveData<Profile>()
    var recentMatches = MutableLiveData<List<RecentMatchItem>>()
    var winrate = MutableLiveData<WinLose>()
    private val heroesList = MutableLiveData<MutableList<Hero>>()

    lateinit var nickname: String
    lateinit var wins: String
    lateinit var lose: String

    fun getProfile() {
        viewModelScope.launch {
            val prof = getPlayerProfileUseCase.getPlayerProfile(account_id)
            heroesList.postValue(getHeroesListUseCase.getHeroes())
            profile.postValue(prof.profile)
            recentMatches.postValue(getRecentMatchesUseCase.getRecentMatches(account_id))
            winrate.postValue(getWinrateUseCase.getWinrate(account_id))
        }
    }

    fun getHero(position: Int): String? {
        val heroPosition = findHero(position)
        val img = heroesList.value?.get(heroPosition)?.icon
        return IMAGE_URL + img
    }

    fun getHeroName(position: Int): String? {
        val heroPostiton = findHero(position)
        return heroesList.value?.get(heroPostiton)?.localized_name
    }


}