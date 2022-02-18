package com.example.dota2stats.domain.playersSearch

data class PlayerSearchItem(
    val account_id: Int,
    val avatarfull: String,
    val last_match_time: String,
    val personaname: String,
    val similarity: Double
)
