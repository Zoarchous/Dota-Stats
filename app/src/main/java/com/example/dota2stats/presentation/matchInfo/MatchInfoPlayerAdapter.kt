package com.example.dota2stats.presentation.matchInfo


import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ListAdapter
import coil.load
import coil.transform.CircleCropTransformation
import coil.util.DebugLogger
import com.example.dota2stats.R
import com.example.dota2stats.data.remoteModel.BASE_URL
import com.example.dota2stats.data.remoteModel.IMAGE_URL
import com.example.dota2stats.domain.constants.Hero
import com.example.dota2stats.domain.matchInfo.InMatchPlayerItem
import com.example.dota2stats.domain.matchInfo.MatchItem
import com.example.dota2stats.findHero
import com.example.dota2stats.presentation.MainActivity
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class MatchInfoPlayerAdapter(var fragment: MatchInfoFragment):
    ListAdapter<InMatchPlayerItem, MatchInfoPlayerViewHolder>(MatchInfoPlayerDiffCallback()) {

    var viewModel: MatchInfoViewModel? = null

    var onPlayerItemClickListener: ((InMatchPlayerItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchInfoPlayerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.match_info_player_item,
            parent,
            false
        )
        viewModel = ViewModelProvider(fragment)[MatchInfoViewModel::class.java]
        return MatchInfoPlayerViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: MatchInfoPlayerViewHolder, position: Int) {
        val item = getItem(position)
        val heroId = item.hero_id
        val icon = viewModel?.getHero(heroId)

        Picasso.get().apply { isLoggingEnabled = true }
            .load(icon)
            .transform(CropCircleTransformation())
            .into(viewHolder.heroIcon)
        viewHolder.playerName.text = item.personaname
        viewHolder.kill.text = "${item.kills} / "
        viewHolder.death.text = "${item.deaths} / "
        viewHolder.assists.text = item.assists.toString()
        viewHolder.heroLvl.text = item.level.toString()

        viewHolder.view.setOnClickListener {
            onPlayerItemClickListener?.invoke(item)
        }
    }
}