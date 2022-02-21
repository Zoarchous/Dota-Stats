package com.example.dota2stats.domain.proPlayers

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "pro_players")
data class ProPlayersItem(
    @PrimaryKey val account_id: Int,
    val avatar: String?,
    val avatarfull: String?,
    val avatarmedium: String?,
    val cheese: Int?,
    val country_code: String?,
    val fantasy_role: Int?,
    val fh_unavailable: Boolean?,
    val full_history_time: String?,
    val is_locked: Boolean?,
    val is_pro: Boolean?,
    val last_login: String?,
    val last_match_time: String?,
    val loccountrycode: String?,
    val locked_until: Int?,
    val name: String?,
    val personaname: String?,
    val plus: Boolean?,
    val profileurl: String?,
    val steamid: String?,
    val team_id: Int?,
    val team_name: String?,
    val team_tag: String?
)