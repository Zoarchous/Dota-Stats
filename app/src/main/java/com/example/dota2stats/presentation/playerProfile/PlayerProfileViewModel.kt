package com.example.dota2stats.presentation.playerProfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.playerProfile.GetPlayerProfileUseCase
import com.example.dota2stats.domain.playerProfile.Profile
import kotlinx.coroutines.launch

class PlayerProfileViewModel(
    repository: Repository,
    var account_id: Int = 0
) : ViewModel() {
    private val getPlayerProfileUseCase = GetPlayerProfileUseCase(repository)

    var profile = MutableLiveData<Profile>()

    fun getProfile() {
        viewModelScope.launch {
            val prof = getPlayerProfileUseCase.getPlayerProfile(account_id)
            profile.postValue(prof.profile)
        }
    }
}