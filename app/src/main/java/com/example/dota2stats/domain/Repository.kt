package com.example.dota2stats.domain

import com.example.dota2stats.domain.constants.Hero
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.playerProfile.PlayerProfile
import com.example.dota2stats.domain.playerProfile.RecentMatchItem
import com.example.dota2stats.domain.playerProfile.WinLose
import com.example.dota2stats.domain.playersSearch.PlayerSearchItem
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.proPlayers.ProPlayersItem
import retrofit2.Call

interface Repository {

    suspend fun getProMatchesList(): MutableList<ProMatchItem>

    fun getProMatchItem(matchId: Long): ProMatchItem

    suspend fun getMatchInfo(matchId: Long): MatchItem

    suspend fun searchPlayers(nickname: String): MutableList<PlayerSearchItem>

    suspend fun getHeroes(): MutableList<Hero>

    suspend fun getPlayerProfile(account_id: Int): PlayerProfile

    suspend fun getRecentMatches(account_id: Int): List<RecentMatchItem>

    suspend fun getWinrate(account_id: Int): WinLose

    suspend fun getProPlayers(): MutableList<ProPlayersItem>
}