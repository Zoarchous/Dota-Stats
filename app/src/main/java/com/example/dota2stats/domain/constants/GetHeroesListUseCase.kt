package com.example.dota2stats.domain.constants

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class GetHeroesListUseCase @Inject constructor(private val repository: Repository) {

    suspend fun getHeroes(): MutableList<Hero> {
        return repository.getHeroes()
    }
}