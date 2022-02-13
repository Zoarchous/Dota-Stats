package com.example.dota2stats.presentation.proMatches


import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.dota2stats.domain.proMatches.ProMatchItem

class ProMatchesAdapter:
    ListAdapter<ProMatchItem, ProMatchItemViewHolder>(ProMatchItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProMatchItemViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProMatchItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}