package com.example.dota2stats.domain.proPlayers

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class GetProPlayersListUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getProPlayers(): MutableList<ProPlayersItem> {
        return repository.getProPlayers()
    }
}