package com.example.dota2stats.domain.matchInfo

import com.example.dota2stats.domain.proMatches.ProMatchRepository
import javax.inject.Inject

class GetMatchInfoUseCase @Inject constructor(
    private val proMatchRepository: ProMatchRepository) {

    suspend fun getMatchInfo(matchId: Long): MatchItem {
        return proMatchRepository.getMatchInfo(matchId)
    }
}