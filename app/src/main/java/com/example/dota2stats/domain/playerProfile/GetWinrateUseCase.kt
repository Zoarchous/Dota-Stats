package com.example.dota2stats.domain.playerProfile

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class GetWinrateUseCase @Inject constructor(private val repository: Repository) {
    suspend fun getWinrate (account_id: Int): WinLose {
        return repository.getWinrate(account_id)
    }
}