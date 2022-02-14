package com.example.dota2stats.data

import androidx.lifecycle.MutableLiveData
import com.example.dota2stats.data.remoteModel.RemoteDataSource
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.domain.proMatches.ProMatchRepository
import javax.inject.Inject

class ProMatchRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    ) : ProMatchRepository {

//    override suspend fun getProMatchesList(): List<ProMatchItem> {
//        return remoteDataSource.getRemoteProMatchesList()
//    }
    override suspend fun getProMatchesList() = remoteDataSource.getRemoteProMatchesList()


    override fun getProMatchItem(matchId: Long): ProMatchItem {
        TODO()
    }

    override suspend fun getMatchInfo(matchId: Long) = remoteDataSource.getMatchInfo(matchId)
}