package com.example.dota2stats.presentation.proMatches

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R

class ProMatchItemViewHolder(val view: View): RecyclerView.ViewHolder(view) {
    val league: TextView = view.findViewById(R.id.leagueName)
    val radiantName: TextView = view.findViewById(R.id.radiantTeam)
    val direName: TextView = view.findViewById(R.id.direTeam)
    val time: TextView = view.findViewById(R.id.matchTime)
    val direIcon: ImageView = view.findViewById(R.id.direIcon)
    val radiantIcon: ImageView = view.findViewById(R.id.radiantIcon)
}