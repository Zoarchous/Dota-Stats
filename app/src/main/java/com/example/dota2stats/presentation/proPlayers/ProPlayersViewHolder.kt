package com.example.dota2stats.presentation.proPlayers

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R

class ProPlayersViewHolder (val view: View): RecyclerView.ViewHolder(view) {
    val avatar: ImageView = view.findViewById(R.id.playerAvatar)
    val nickname: TextView = view.findViewById(R.id.playerNickname)
    val team: TextView = view.findViewById(R.id.playerTeam)
}