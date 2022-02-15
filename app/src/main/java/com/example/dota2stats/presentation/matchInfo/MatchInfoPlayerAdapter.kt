package com.example.dota2stats.presentation.matchInfo


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.R
import com.example.dota2stats.domain.matchInfo.InMatchPlayerItem
import com.example.dota2stats.domain.matchInfo.MatchItem

class MatchInfoPlayerAdapter: ListAdapter<InMatchPlayerItem, MatchInfoPlayerViewHolder>(MatchInfoPlayerDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchInfoPlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.match_info_player_item,
            parent,
            false
        )
        return MatchInfoPlayerViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MatchInfoPlayerViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.heroIcon.setImageResource(R.drawable.ic_android_black_24dp)
        viewHolder.playerName.text = item.personaname
        viewHolder.kill.text = item.kills.toString()
        viewHolder.death.text = item.deaths.toString()
        viewHolder.assists.text = item.assists.toString()
        viewHolder.heroLvl.text = item.level.toString()
    }
}