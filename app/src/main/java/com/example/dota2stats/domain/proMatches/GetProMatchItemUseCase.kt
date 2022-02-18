package com.example.dota2stats.domain.proMatches

import com.example.dota2stats.domain.Repository

class GetProMatchItemUseCase (private val repository: Repository) {
    fun getProMatchItem(matchId: Long): ProMatchItem{
        return repository.getProMatchItem(matchId)
    }
}