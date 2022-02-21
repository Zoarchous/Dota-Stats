package com.example.dota2stats.presentation.proPlayers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.R
import com.example.dota2stats.domain.playersSearch.PlayerSearchItem
import com.example.dota2stats.domain.proPlayers.ProPlayersItem
import com.example.dota2stats.presentation.playersSearch.PlayerSearchViewHolder
import com.example.dota2stats.presentation.playersSearch.PlayersSearchDiffCallback
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class ProPlayersAdapter : ListAdapter<ProPlayersItem, ProPlayersViewHolder>(
    ProPlayersDiffCallback()
) {

    var onPlayerItemClickListener: ((ProPlayersItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProPlayersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.pro_player_item,
            parent,
            false
        )
        return ProPlayersViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProPlayersViewHolder, position: Int) {
        val item = getItem(position)
        Picasso.get()
            .load(item.avatarfull)
            .transform(CropCircleTransformation())
            .into(viewHolder.avatar)
        viewHolder.nickname.text = item.name
        viewHolder.team.text = item.team_name ?: "Teamless"

        viewHolder.view.setOnClickListener {
            onPlayerItemClickListener?.invoke(item)
        }
    }
}