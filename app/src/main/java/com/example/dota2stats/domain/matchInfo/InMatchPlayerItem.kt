package com.example.dota2stats.domain.matchInfo

import com.example.dota2stats.domain.constants.Hero

data class InMatchPlayerItem(
    val account_id: Int,
    val assists: Int,
    val deaths: Int,
    val denies: Int,
    val duration: Int,
    val game_mode: Int,
    val gold: Int,
    val gold_per_min: Int,
    val hero_damage: Int,
    val hero_healing: Int,
    val hero_id: Int,
    val isRadiant: Boolean,
    val kills: Int,
    val kda: Int,
    val level: Int,
    val match_id: Long,
    val name: String,
    val net_worth: Int,
    val personaname: String,
    val player_slot: Int,
    val radiant_win: Boolean,
    val total_gold: Int,
    val total_xp: Int,
    val tower_damage: Int,
    val win: Int,
    val xp_per_min: Int,
    val hero: Hero
)