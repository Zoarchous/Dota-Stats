package com.example.dota2stats.presentation.proMatches


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.R
import com.example.dota2stats.R.drawable.ic_android_black_24dp
import com.example.dota2stats.domain.proMatches.ProMatchItem

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
        viewHolder.league.text = item.league_name
        viewHolder.direName.text = item.dire_name
        viewHolder.radiantName.text = item.radiant_name
        viewHolder.time.text = item.duration.toString()
        viewHolder.direIcon.setImageResource(ic_android_black_24dp)
        viewHolder.radiantIcon.setImageResource(ic_android_black_24dp)
        if (item.radiant_win){
            viewHolder.direIcon.visibility = View.GONE
        } else {
            viewHolder.radiantIcon.visibility = View.GONE
        }

        viewHolder.view.setOnClickListener {
            onProMatchClickListener?.invoke(item)
        }
    }
}