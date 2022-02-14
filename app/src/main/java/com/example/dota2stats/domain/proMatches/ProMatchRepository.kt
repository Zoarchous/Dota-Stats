package com.example.dota2stats.domain.proMatches

import androidx.lifecycle.MutableLiveData
import com.example.dota2stats.domain.matchInfo.MatchItem

interface ProMatchRepository {

    suspend fun getProMatchesList(): MutableList<ProMatchItem>

    fun getProMatchItem(matchId: Long): ProMatchItem

    suspend fun getMatchInfo(matchId: Long): MatchItem
}