package com.example.dota2stats.presentation.matchInfo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R

class MatchInfoPlayerViewHolder (val view: View): RecyclerView.ViewHolder(view) {
    val heroIcon: ImageView = view.findViewById(R.id.heroIcon)
    val playerName: TextView = view.findViewById(R.id.playerName)
    val kill: TextView = view.findViewById(R.id.kills)
    val death: TextView = view.findViewById(R.id.death)
    val assists: TextView = view.findViewById(R.id.assists)
    val heroLvl: TextView = view.findViewById(R.id.heroLvl)
}