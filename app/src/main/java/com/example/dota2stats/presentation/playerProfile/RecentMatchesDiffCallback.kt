package com.example.dota2stats.presentation.playerProfile

import androidx.recyclerview.widget.DiffUtil
import com.example.dota2stats.domain.playerProfile.RecentMatchItem

class RecentMatchesDiffCallback: DiffUtil.ItemCallback<RecentMatchItem>() {
    override fun areItemsTheSame(oldItem: RecentMatchItem, newItem: RecentMatchItem): Boolean {
        return oldItem.match_id == newItem.match_id
    }

    override fun areContentsTheSame(oldItem: RecentMatchItem, newItem: RecentMatchItem): Boolean {
        return oldItem == newItem
    }
}