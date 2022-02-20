package com.example.dota2stats.presentation.playersSearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.R
import com.example.dota2stats.domain.playersSearch.PlayerSearchItem
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class PlayersSearchAdapter: ListAdapter<PlayerSearchItem, PlayerSearchViewHolder>(PlayersSearchDiffCallback()) {

    var onPlayerItemClickListener: ((PlayerSearchItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerSearchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.players_search_item,
            parent,
            false
        )
        return PlayerSearchViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: PlayerSearchViewHolder, position: Int) {
        val item = getItem(position)
        Picasso.get()
            .load(item.avatarfull)
            .transform(CropCircleTransformation())
            .into(viewHolder.avatar)
        viewHolder.nickname.text = item.personaname

        viewHolder.view.setOnClickListener {
            onPlayerItemClickListener?.invoke(item)
        }
    }
}