package com.example.dota2stats.presentation.proMatches


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.R
import com.example.dota2stats.R.drawable.ic_android_black_24dp
import com.example.dota2stats.R.drawable.trophy
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.formatTime

class ProMatchesAdapter:
    ListAdapter<ProMatchItem, ProMatchItemViewHolder>(ProMatchItemDiffCallback()) {

    var onProMatchClickListener: ((ProMatchItem) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProMatchItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.pro_match_item,
            parent,
            false
        )
        return ProMatchItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ProMatchItemViewHolder, position: Int) {
        val item = getItem(position)
        viewHolder.league.text = item.leagueid.toString()
        viewHolder.direName.text = item.dire_name ?: "Dire"
        viewHolder.radiantName.text = item.radiant_name ?: "Radiant"
        viewHolder.time.text = formatTime(item.duration)
        viewHolder.direIcon.setImageResource(trophy)
        viewHolder.radiantIcon.setImageResource(trophy)
        if (item.radiant_win){
            viewHolder.direIcon.visibility = View.INVISIBLE
            viewHolder.radiantIcon.visibility = View.VISIBLE
        } else {
            viewHolder.radiantIcon.visibility = View.INVISIBLE
            viewHolder.direIcon.visibility = View.VISIBLE
        }

        viewHolder.view.setOnClickListener {
            onProMatchClickListener?.invoke(item)
        }
    }
}