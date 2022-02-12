package com.example.dota2stats.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.proMatches.ProMatchRepository
import java.lang.RuntimeException

object ProMatchRepositoryImpl: ProMatchRepository {
    private val proMatchList = mutableListOf<ProMatchItem>()
    private val proMatchListLD = MutableLiveData<List<ProMatchItem>>()

    override fun getProMatchesList(): LiveData<List<ProMatchItem>> {
        return proMatchListLD
    }

    override fun getProMatchItem(matchId: Long): ProMatchItem {
        return proMatchList.find {
            it.match_id == matchId
        } ?:throw RuntimeException("Element with id $matchId not found")
    }
}