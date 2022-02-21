package com.example.dota2stats.data.localModel

import android.content.Context
import com.example.dota2stats.data.localModel.db.AppDatabase
import com.example.dota2stats.domain.proPlayers.ProPlayersItem
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(@ApplicationContext context: Context) {
    private val database = AppDatabase.getInstance(context)

    fun getProPlayersDatabase(): MutableList<ProPlayersItem> {
        return database.proPlayersDao().getProPlayersDatabase()
    }

    suspend fun clear(){
        database.proPlayersDao().clear()
    }

    suspend fun insertProPlayers(proPlayers: MutableList<ProPlayersItem>){
        database.proPlayersDao().insertProPlayers(proPlayers)
    }
}