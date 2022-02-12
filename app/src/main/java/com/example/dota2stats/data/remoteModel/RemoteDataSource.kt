package com.example.dota2stats.data.remoteModel

import android.util.Log
import com.example.dota2stats.domain.proMatches.ProMatchItem
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {
    val apiRequest = ApiRequest.create()


    suspend fun getRemoteProMatchesList(): MutableList<ProMatchItem> {
        return try {
            val proMatches = apiRequest.getProMatches()
            Log.d("!!!Remote", proMatches.toString())
            proMatches
        } catch (e: Exception) {
            mutableListOf()
        }

    }
}