package com.example.dota2stats.data

import com.example.dota2stats.data.localModel.LocalDataSource
import com.example.dota2stats.data.remoteModel.RemoteDataSource
import com.example.dota2stats.domain.Repository
import com.example.dota2stats.domain.proPlayers.ProPlayersItem
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {


    override suspend fun getProMatchesList() = remoteDataSource.getRemoteProMatchesList()

    override suspend fun getMatchInfo(matchId: Long) = remoteDataSource.getMatchInfo(matchId)

    override suspend fun searchPlayers(nickname: String) = remoteDataSource.searchPlayers(nickname)

    override suspend fun getHeroes() = remoteDataSource.getHeroes()

    override suspend fun getPlayerProfile(account_id: Int) =
        remoteDataSource.getPlayerProfile(account_id)

    override suspend fun getRecentMatches(account_id: Int) =
        remoteDataSource.getRecentMatches(account_id)

    override suspend fun getWinrate(account_id: Int) = remoteDataSource.getWinrate(account_id)

    override suspend fun getProPlayers(): MutableList<ProPlayersItem> {
        var proPlayersList = localDataSource.getProPlayersDatabase()
        return if (proPlayersList.isEmpty()) {
            proPlayersList = remoteDataSource.getProPlayers()
            localDataSource.insertProPlayers(proPlayersList)
            proPlayersList
        } else {
            proPlayersList
        }
    }


}