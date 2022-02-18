package com.example.dota2stats.domain.playersSearch

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class SearchPlayersUseCase @Inject constructor(private val repository: Repository) {

    suspend fun searchPlayers(nickname: String): MutableList<PlayerSearchItem>{
        return repository.searchPlayers(nickname)
    }
}