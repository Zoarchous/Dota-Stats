package com.example.dota2stats.domain.proMatches

class GetProMatchItemUseCase (private val proMatchRepository: ProMatchRepository) {
    fun getProMatchItem(matchId: Long): ProMatchItem{
        return proMatchRepository.getProMatchItem(matchId)
    }
}