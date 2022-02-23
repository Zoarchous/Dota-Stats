package com.example.dota2stats.presentation.playerProfile

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.R
import com.example.dota2stats.domain.playerProfile.RecentMatchItem
import com.example.dota2stats.presentation.MainActivity
import com.example.dota2stats.showGameMode
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class RecentMatchesAdapter(var fragment: PlayerProfileFragment):
    ListAdapter<RecentMatchItem, RecentMatchesViewHolder>(RecentMatchesDiffCallback()) {

    var viewModel: PlayerProfileViewModel? = null

    var onRecentMatchItemClickListener: ((RecentMatchItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentMatchesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recent_matches_item,
            parent,
            false
        )
        viewModel = ViewModelProvider(fragment)[PlayerProfileViewModel::class.java]
        return RecentMatchesViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecentMatchesViewHolder, position: Int) {
        val item = getItem(position)
        val heroId = item.hero_id
        val icon = viewModel?.getHero(heroId)
        Picasso.get()
            .load(icon)
            .transform(CropCircleTransformation())
            .into(viewHolder.heroIcon)
        viewHolder.playerName.text = viewModel?.getHeroName(heroId)
        viewHolder.kill.text = "${item.kills} / "
        viewHolder.death.text = "${item.deaths} / "
        viewHolder.assists.text = item.assists.toString()
        viewHolder.heroLvl.text = showGameMode(item.game_mode)

        viewHolder.view.setOnClickListener {
            onRecentMatchItemClickListener?.invoke(item)
        }
    }
}