package com.example.dota2stats.domain.matchInfo

data class MatchItem (
    val match_id: Long,
    val dire_score: Int,
    val duration: Int,
    val game_mode: Int,
    val radiant_score: Int,
    val radiant_win: Boolean,
    val players: List<InMatchPlayerItem>
)
