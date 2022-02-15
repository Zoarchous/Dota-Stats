package com.example.dota2stats.presentation.matchInfo

import androidx.recyclerview.widget.DiffUtil
import com.example.dota2stats.domain.matchInfo.InMatchPlayerItem
import com.example.dota2stats.domain.matchInfo.MatchItem

class MatchInfoPlayerDiffCallback: DiffUtil.ItemCallback<InMatchPlayerItem>() {
    override fun areItemsTheSame(oldItem: InMatchPlayerItem, newItem: InMatchPlayerItem): Boolean {
        return oldItem.account_id == newItem.account_id
    }

    override fun areContentsTheSame(
        oldItem: InMatchPlayerItem,
        newItem: InMatchPlayerItem
    ): Boolean {
        return oldItem == newItem
    }
}