package com.example.dota2stats.domain.proMatches

import androidx.lifecycle.MutableLiveData

interface ProMatchRepository {

    suspend fun getProMatchesList(): MutableList<ProMatchItem>

    fun getProMatchItem(matchId: Long): ProMatchItem
}