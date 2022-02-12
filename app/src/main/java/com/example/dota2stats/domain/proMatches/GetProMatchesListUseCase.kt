package com.example.dota2stats.domain.proMatches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject

class GetProMatchesListUseCase @Inject constructor(
    private val proMatchRepository: ProMatchRepository) {

    suspend fun getProMatchesList(): MutableList<ProMatchItem> {
        return proMatchRepository.getProMatchesList()
    }
}