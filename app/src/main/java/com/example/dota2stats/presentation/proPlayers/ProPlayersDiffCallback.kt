package com.example.dota2stats.presentation.proPlayers

import androidx.recyclerview.widget.DiffUtil
import com.example.dota2stats.domain.proPlayers.ProPlayersItem

class ProPlayersDiffCallback: DiffUtil.ItemCallback<ProPlayersItem>() {
    override fun areItemsTheSame(oldItem: ProPlayersItem, newItem: ProPlayersItem): Boolean {
        return oldItem.account_id == newItem.account_id
    }

    override fun areContentsTheSame(oldItem: ProPlayersItem, newItem: ProPlayersItem): Boolean {
        return oldItem == newItem
    }
}