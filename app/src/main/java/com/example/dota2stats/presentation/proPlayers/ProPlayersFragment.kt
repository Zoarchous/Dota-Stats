package com.example.dota2stats.presentation.proPlayers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dota2stats.R
import com.example.dota2stats.databinding.FragmentProPlayersBinding
import com.example.dota2stats.presentation.MainActivity
import com.example.dota2stats.presentation.playersSearch.PlayerSearchViewModel
import com.example.dota2stats.presentation.playersSearch.PlayersSearchAdapter
import com.example.dota2stats.presentation.playersSearch.PlayersSearchFragmentArgs
import com.example.dota2stats.presentation.playersSearch.PlayersSearchFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProPlayersFragment : Fragment() {
    private lateinit var binding: FragmentProPlayersBinding
    @Inject
    lateinit var proPlayersFactory: ProPlayersViewModelFactory
    private lateinit var viewModel: ProPlayersViewModel
    private lateinit var recyclerAdapter: ProPlayersAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProPlayersBinding.inflate(inflater)
        setupViewModel()
        setupRecycler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressBar.visibility = View.GONE
        viewModel.players.observe(this, {
            recyclerAdapter.submitList(it)
        })
    }

    private fun setupViewModel (){
        viewModel =
            ViewModelProvider(this, proPlayersFactory)[ProPlayersViewModel::class.java]
//        viewModel = ViewModelProvider(activity as MainActivity)[ProPlayersViewModel::class.java]
        viewModel.getProPlayers()
    }

    private fun setupRecycler(){
        with(binding.ProPlayersRecycler){
            recyclerAdapter = ProPlayersAdapter()
            adapter = recyclerAdapter
        }
        setupItemClickListener()
    }

    private fun setupItemClickListener(){
        recyclerAdapter.onPlayerItemClickListener = {
            this.findNavController().navigate(
                ProPlayersFragmentDirections
                    .actionProPlayersFragmentToPlayerProfileFragment(it.account_id)
            )
        }
    }
}