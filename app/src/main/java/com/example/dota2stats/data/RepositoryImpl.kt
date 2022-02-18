package com.example.dota2stats.data

import com.example.dota2stats.data.remoteModel.RemoteDataSource
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.playersSearch.PlayerSearchItem
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
}