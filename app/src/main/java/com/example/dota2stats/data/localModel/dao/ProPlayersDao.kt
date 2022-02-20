package com.example.dota2stats.data.localModel.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import com.example.dota2stats.domain.proPlayers.ProPlayersItem


@Dao
interface ProPlayersDao {
    @Query ("SELECT * FROM pro_players")
    fun getProPlayersDatabase(): MutableList<ProPlayersItem>

    @Query ("DELETE FROM pro_players")
    suspend fun clear()
}