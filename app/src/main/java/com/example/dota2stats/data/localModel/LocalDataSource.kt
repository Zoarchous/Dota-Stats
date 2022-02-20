package com.example.dota2stats.data.localModel

import android.content.Context
import com.example.dota2stats.data.localModel.db.AppDatabase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LocalDataSource @Inject constructor(@ApplicationContext context: Context) {
    private val database = AppDatabase.getInstance(context)
}