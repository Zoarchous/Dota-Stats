package com.example.dota2stats.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2stats.domain.proMatches.GetProMatchesListUseCase
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.constants.GetHeroesListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (repository: Repository): ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO)

    private val getProMatchesListUseCase = GetProMatchesListUseCase(repository)




    val list = MutableLiveData<List<ProMatchItem>>()

    fun getProMatches() {
        scope.launch {
            val data = getProMatchesListUseCase.getProMatchesList()
            list.postValue(data)
        }
    }

}