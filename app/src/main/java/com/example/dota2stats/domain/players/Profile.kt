package com.example.dota2stats.domain.players

data class Profile (
    val account_id: Int,
    val avatar: String,
    val avatarfull: String,
    val avatarmedium: String,
    val name: String,
    val personaname: String,
    val profileurl: String,
    val steamid: String
        )