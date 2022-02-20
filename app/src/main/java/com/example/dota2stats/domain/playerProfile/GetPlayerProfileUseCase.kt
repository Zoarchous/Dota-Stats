package com.example.dota2stats.domain.playerProfile

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class GetPlayerProfileUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getPlayerProfile (account_id: Int): PlayerProfile {
        return repository.getPlayerProfile(account_id)
    }
}