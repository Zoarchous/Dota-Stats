package com.example.dota2stats.presentation.playersSearch

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R

class PlayerSearchViewHolder (val view: View): RecyclerView.ViewHolder(view) {
    val avatar: ImageView = view.findViewById(R.id.playerAvatar)
    val nickname: TextView = view.findViewById(R.id.playerNickname)
}