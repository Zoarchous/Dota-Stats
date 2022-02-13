package com.example.dota2stats.presentation.proMatches

import androidx.recyclerview.widget.DiffUtil
import com.example.dota2stats.domain.proMatches.ProMatchItem

class ProMatchItemDiffCallback: DiffUtil.ItemCallback<ProMatchItem>(){
    override fun areItemsTheSame(oldItem: ProMatchItem, newItem: ProMatchItem): Boolean {
        return oldItem.match_id == newItem.match_id
    }

    override fun areContentsTheSame(oldItem: ProMatchItem, newItem: ProMatchItem): Boolean {
        return oldItem == newItem
    }

}
