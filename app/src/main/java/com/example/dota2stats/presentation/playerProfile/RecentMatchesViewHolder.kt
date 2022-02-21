package com.example.dota2stats.presentation.playerProfile

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R

class RecentMatchesViewHolder (val view: View): RecyclerView.ViewHolder(view) {
    val heroIcon: ImageView = view.findViewById(R.id.recentHeroIcon)
    val playerName: TextView = view.findViewById(R.id.recentPlayerName)
    val kill: TextView = view.findViewById(R.id.recentKills)
    val death: TextView = view.findViewById(R.id.recentDeath)
    val assists: TextView = view.findViewById(R.id.recentAssists)
    val heroLvl: TextView = view.findViewById(R.id.recentHeroLvl)
}