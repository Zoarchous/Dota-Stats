package com.example.dota2stats.data

import com.example.dota2stats.data.remoteModel.RemoteDataSource
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.playerProfile.PlayerProfile
import com.example.dota2stats.domain.playerProfile.RecentMatchItem
import com.example.dota2stats.domain.playerProfile.WinLose
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    ) : Repository {

//    override suspend fun getProMatchesList(): List<ProMatchItem> {
//        return remoteDataSource.getRemoteProMatchesList()
//    }
    override suspend fun getProMatchesList() = remoteDataSource.getRemoteProMatchesList()


    override fun getProMatchItem(matchId: Long): ProMatchItem {
        TODO()
    }

    override suspend fun getMatchInfo(matchId: Long) = remoteDataSource.getMatchInfo(matchId)

    override suspend fun searchPlayers(nickname: String) = remoteDataSource.searchPlayers(nickname)

    override suspend fun getHeroes() = remoteDataSource.getHeroes()

    override suspend fun getPlayerProfile(account_id: Int) = remoteDataSource.getPlayerProfile(account_id)

    override suspend fun getRecentMatches(account_id: Int) = remoteDataSource.getRecentMatches(account_id)

    override suspend fun getWinrate(account_id: Int) = remoteDataSource.getWinrate(account_id)


}