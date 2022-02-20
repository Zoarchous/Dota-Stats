package com.example.dota2stats.data.localModel.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dota2stats.data.localModel.dao.ProPlayersDao
import com.example.dota2stats.domain.proPlayers.ProPlayersItem

@Database (entities = [ProPlayersItem::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun proPlayersDao(): ProPlayersDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}