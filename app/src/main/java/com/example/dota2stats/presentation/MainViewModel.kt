package com.example.dota2stats.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dota2stats.data.ProMatchRepositoryImpl
import com.example.dota2stats.domain.proMatches.GetProMatchItemUseCase
import com.example.dota2stats.domain.proMatches.GetProMatchesListUseCase
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.proMatches.ProMatchRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (repository: ProMatchRepository): ViewModel() {
    val scope = CoroutineScope(Dispatchers.IO)

    val getProMatchesListUseCase = GetProMatchesListUseCase(repository)

    val list: MutableLiveData<MutableList<ProMatchItem>> by lazy {
        MutableLiveData<MutableList<ProMatchItem>>(mutableListOf())
    }

    fun getProMatches(): MutableLiveData<MutableList<ProMatchItem>>{
        scope.launch {
            val data = getProMatchesListUseCase.getProMatchesList()
            list.postValue(data)
        }
        Log.d("!!!ViewModel", list.value.toString())
        return list

    }
}