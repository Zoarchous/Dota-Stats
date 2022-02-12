package com.example.dota2stats.domain.proMatches

data class ProMatchItem (
    val dire_name: String,
    val dire_score: Int,
    val dire_team_id: Int,
    val duration: Int,
    val league_name: String,
    val leagueid: Int,
    val match_id: Long,
    val radiant_name: String,
    val radiant_score: Int,
    val radiant_team_id: Int,
    val radiant_win: Boolean,
    val series_id: Int,
    val series_type: Int,
    val start_time: Int
)