package com.example.dota2stats.domain.proMatches

import androidx.lifecycle.LiveData

class GetProMatchesListUseCase (private val proMatchRepository: ProMatchRepository){
    fun getProMatchesList(): LiveData<List<ProMatchItem>>{
        return proMatchRepository.getProMatchesList()
    }
}