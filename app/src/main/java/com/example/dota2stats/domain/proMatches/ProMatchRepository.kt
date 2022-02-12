package com.example.dota2stats.domain.proMatches

import androidx.lifecycle.LiveData

interface ProMatchRepository {
    fun getProMatchesList (): LiveData<List<ProMatchItem>>

    fun getProMatchItem (matchId: Long): ProMatchItem
}