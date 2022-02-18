package com.example.dota2stats.domain.matchInfo

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class GetMatchInfoUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun getMatchInfo(matchId: Long): MatchItem {
        return repository.getMatchInfo(matchId)
    }
}