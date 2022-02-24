package com.example.dota2stats.presentation.proMatches

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dota2stats.domain.proMatches.GetProMatchesListUseCase
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.Repository
import kotlinx.coroutines.launch

class ProMatchesViewModel(repository: Repository) : ViewModel() {

    private val getProMatchesListUseCase = GetProMatchesListUseCase(repository)

    val list = MutableLiveData<List<ProMatchItem>>()

    fun getProMatches() {
        viewModelScope.launch {
            val data = getProMatchesListUseCase.getProMatchesList()
            list.postValue(data)
        }
    }

}