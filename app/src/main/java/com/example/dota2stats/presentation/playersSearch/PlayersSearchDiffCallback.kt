package com.example.dota2stats.presentation.playersSearch

import androidx.recyclerview.widget.DiffUtil
import com.example.dota2stats.domain.playersSearch.PlayerSearchItem

class PlayersSearchDiffCallback: DiffUtil.ItemCallback<PlayerSearchItem>() {
    override fun areItemsTheSame(oldItem: PlayerSearchItem, newItem: PlayerSearchItem): Boolean {
        return oldItem.account_id == newItem.account_id
    }

    override fun areContentsTheSame(oldItem: PlayerSearchItem, newItem: PlayerSearchItem): Boolean {
        return oldItem == newItem
    }

}