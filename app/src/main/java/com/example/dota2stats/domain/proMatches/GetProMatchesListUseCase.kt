package com.example.dota2stats.domain.proMatches

import com.example.dota2stats.domain.Repository
import javax.inject.Inject

class GetProMatchesListUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend fun getProMatchesList(): MutableList<ProMatchItem> {
        return repository.getProMatchesList()
    }
}