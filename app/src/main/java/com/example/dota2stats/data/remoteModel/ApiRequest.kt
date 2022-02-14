package com.example.dota2stats.data.remoteModel

import androidx.lifecycle.LiveData
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.domain.proMatches.ProMatchItem
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

val BASE_URL = "https://api.opendota.com/api/"

interface ApiRequest {
    @GET("proMatches")
    suspend fun getProMatches(): MutableList<ProMatchItem>

    @GET("matches/{match_id}")
    suspend fun getMatchInfo(
        @Path("match_id") match_id: Long
    ): MatchItem

    companion object {
        fun create(): ApiRequest {
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit.create(ApiRequest::class.java)
        }
    }
}