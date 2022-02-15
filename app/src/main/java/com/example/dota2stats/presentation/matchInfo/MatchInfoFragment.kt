package com.example.dota2stats.presentation.matchInfo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.R
import com.example.dota2stats.data.ProMatchRepositoryImpl
import com.example.dota2stats.databinding.FragmentMatchInfoBinding
import com.example.dota2stats.presentation.MainActivity
import com.example.dota2stats.presentation.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class MatchInfoFragment : Fragment() {
    private lateinit var binding: FragmentMatchInfoBinding
    private lateinit var viewModel: MatchInfoViewModel
    private lateinit var recyclerAdapter: MatchInfoPlayerAdapter
    private lateinit var recyclerAdapter2: MatchInfoPlayerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchInfoBinding.inflate(inflater)
        setupViewModel()
        setupRecycler()
        viewModel.players.observe(this, {
            recyclerAdapter.submitList(it.filter {inMatchPlayerItem ->
                inMatchPlayerItem.player_slot <= 5
            })
            recyclerAdapter2.submitList(it.filter { item ->
                item.player_slot >= 6
            })
            Log.d("!!!list", it.toString())
        })

        return binding.root
    }

    private fun setupViewModel(){
        val arguments = MatchInfoFragmentArgs.fromBundle(requireArguments())
        viewModel = ViewModelProvider(activity as MainActivity)[MatchInfoViewModel::class.java]
        viewModel.matchId = arguments.matchId
        viewModel.getPlayersList()
    }

    private fun setupRecycler(){
        with(binding.radiantTeamPlayers){
            recyclerAdapter = MatchInfoPlayerAdapter()
            adapter = recyclerAdapter
        }
        with(binding.direTeamPlayers){
            recyclerAdapter2 = MatchInfoPlayerAdapter()
            adapter = recyclerAdapter2
        }
    }

}