package com.example.dota2stats.presentation.playerProfile

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.R
import com.example.dota2stats.domain.playerProfile.RecentMatchItem
import com.example.dota2stats.presentation.MainActivity

class RecentMatchesAdapter(var activity: Activity):
    ListAdapter<RecentMatchItem, RecentMatchesViewHolder>(RecentMatchesDiffCallback()) {

    var vieModel: PlayerProfileViewModel? = null

    var onRecentMatchItemClickListener: ((RecentMatchItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentMatchesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.recent_matches_item,
            parent,
            false
        )
        vieModel = ViewModelProvider(activity as MainActivity)[PlayerProfileViewModel::class.java]
        return RecentMatchesViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecentMatchesViewHolder, position: Int) {
        val item = getItem(position)
        val heroId = item.hero_id
        viewHolder.heroIcon.setImageResource(R.drawable.ic_android_black_24dp)
        viewHolder.playerName.text = vieModel?.profile?.value?.personaname
        viewHolder.kill.text = "${item.kills} / "
        viewHolder.death.text = "${item.deaths} / "
        viewHolder.assists.text = item.assists.toString()
        viewHolder.heroLvl.text = "25"

        viewHolder.view.setOnClickListener {
            onRecentMatchItemClickListener?.invoke(item)
        }
    }
}