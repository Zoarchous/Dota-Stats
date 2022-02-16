package com.example.dota2stats.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2stats.data.ProMatchRepositoryImpl
import com.example.dota2stats.domain.matchInfo.GetMatchInfoUseCase
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.proMatches.GetProMatchItemUseCase
import com.example.dota2stats.domain.proMatches.GetProMatchesListUseCase
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.proMatches.ProMatchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (repository: ProMatchRepository): ViewModel() {
    private val scope = CoroutineScope(Dispatchers.IO)

    private val getProMatchesListUseCase = GetProMatchesListUseCase(repository)


    val list: MutableLiveData<MutableList<ProMatchItem>> by lazy {
        MutableLiveData<MutableList<ProMatchItem>>(mutableListOf())
    }

    fun getProMatches() {
        scope.launch {
            val data = getProMatchesListUseCase.getProMatchesList()
            list.postValue(data)
        }
    }

}