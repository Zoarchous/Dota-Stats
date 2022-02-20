package com.example.dota2stats.data.remoteModel

import android.util.Log
import com.example.dota2stats.domain.constants.Hero
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.playerProfile.PlayerProfile
import com.example.dota2stats.domain.playersSearch.PlayerSearchItem
import com.example.dota2stats.domain.proMatches.ProMatchItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor() {
    private val apiRequest = ApiRequest.create()


    suspend fun getRemoteProMatchesList(): MutableList<ProMatchItem> {
        return try {
            val proMatches = apiRequest.getProMatches()
            Log.d("!!!Remote", proMatches.toString())
            proMatches
        } catch (e: Exception) {
            mutableListOf()
        }
    }

    suspend fun getMatchInfo(matchId: Long): MatchItem {
        return apiRequest.getMatchInfo(matchId)
    }

    suspend fun searchPlayers(nickname: String): MutableList<PlayerSearchItem>{
        return apiRequest.searchPlayers(nickname)
    }

    suspend fun getHeroes(): MutableList<Hero>{
        return apiRequest.getHeroes()
    }

    suspend fun getPlayerProfile(account_id: Int): PlayerProfile {
        return apiRequest.getPlayerProfile(account_id)
    }
}