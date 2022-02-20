package com.example.dota2stats.domain.playerProfile

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class GetRecentMatchesUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getRecentMatches(account_id: Int): List<RecentMatchItem> {
        return repository.getRecentMatches(account_id)
    }
}