package com.example.dota2stats.presentation.playerProfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.playerProfile.*
import kotlinx.coroutines.launch

class PlayerProfileViewModel(
    repository: Repository,
    var account_id: Int = 0
) : ViewModel() {
    private val getPlayerProfileUseCase = GetPlayerProfileUseCase(repository)
    private val getRecentMatchesUseCase = GetRecentMatchesUseCase(repository)
    private val getWinrateUseCase = GetWinrateUseCase(repository)

    var profile = MutableLiveData<Profile>()
    var recentMatches = MutableLiveData<List<RecentMatchItem>>()
    var winrate = MutableLiveData<WinLose>()

    fun getProfile() {
        viewModelScope.launch {
            val prof = getPlayerProfileUseCase.getPlayerProfile(account_id)
            profile.postValue(prof.profile)
            recentMatches.postValue(getRecentMatchesUseCase.getRecentMatches(account_id))
            winrate.postValue(getWinrateUseCase.getWinrate(account_id))
        }
    }

}