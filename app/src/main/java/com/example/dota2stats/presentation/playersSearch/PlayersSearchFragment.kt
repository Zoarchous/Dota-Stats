package com.example.dota2stats.presentation.playersSearch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dota2stats.R
import com.example.dota2stats.databinding.FragmentPlayersSearchBinding
import com.example.dota2stats.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PlayersSearchFragment : Fragment() {
    private lateinit var binding: FragmentPlayersSearchBinding
    private lateinit var viewModel: PlayerSearchViewModel
    private lateinit var recyclerAdapter: PlayersSearchAdapter
    @Inject
    lateinit var playerSearchFactory: PlayerSearchViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayersSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupRecycler()
        viewModel.players.observe(this, {
            recyclerAdapter.submitList(it)
            if (it.isNotEmpty()){
                binding.progressBar.visibility = View.GONE
            }
        })
    }

    private fun setupViewModel (){
        val arguments = PlayersSearchFragmentArgs.fromBundle(requireArguments())
        viewModel =
            ViewModelProvider(this, playerSearchFactory)[PlayerSearchViewModel::class.java]
        viewModel.nickname = arguments.nickname ?: ""
        viewModel.getPlayers()
    }

    private fun setupRecycler(){
        with(binding.playersRecycler){
            recyclerAdapter = PlayersSearchAdapter()
            adapter = recyclerAdapter
        }
        setupItemClickListener()
    }

    private fun setupItemClickListener(){
        recyclerAdapter.onPlayerItemClickListener = {
            this.findNavController().navigate(
                PlayersSearchFragmentDirections
                    .actionPlayersSearchFragmentToPlayerProfileFragment(it.account_id)
            )
        }
    }
}