package com.example.dota2stats.presentation.matchInfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.data.ProMatchRepositoryImpl
import com.example.dota2stats.data.remoteModel.RemoteDataSource
import com.example.dota2stats.databinding.FragmentMatchInfoBinding
import com.example.dota2stats.presentation.MainActivity
import dagger.Component
import javax.inject.Inject


class MatchInfoFragment : Fragment() {
    private lateinit var binding: FragmentMatchInfoBinding
    private lateinit var viewModel: MatchInfoViewModel
    private lateinit var radiantTeamAdapter: MatchInfoPlayerAdapter
    private lateinit var direTeamAdapter: MatchInfoPlayerAdapter
    @Inject lateinit var matchFactory: MatchInfoViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchInfoBinding.inflate(inflater)
        setupViewModel()
        setupRecycler()

        viewModel.matchItem.observe(this, {

            binding.radiantScore.text = it.radiant_score.toString()
            binding.direScore.text = it.dire_score.toString()
            binding.matchDuration.text = it.duration.toString()
            binding.gameMode.text = it.game_mode.toString()
        })
        viewModel.players.observe(this, {
            if (it.isNotEmpty()){
                binding.infoLayout.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }

            radiantTeamAdapter.submitList(it.filter { inMatchPlayerItem ->
                inMatchPlayerItem.player_slot <= 5
            })
            direTeamAdapter.submitList(it.filter { item ->
                item.player_slot >= 6
            })
            Log.d("!!!list", it.toString())
        })
        return binding.root
    }

    private fun setupViewModel() {
        val arguments = MatchInfoFragmentArgs.fromBundle(requireArguments())
        matchFactory = MatchInfoViewModelFactory(repository = ProMatchRepositoryImpl(remoteDataSource = RemoteDataSource()))
        viewModel = ViewModelProvider(this, matchFactory)[MatchInfoViewModel::class.java]
        viewModel.matchId = arguments.matchId
        viewModel.getPlayersList()
    }

    private fun setupRecycler() {
        with(binding.radiantTeamPlayers) {
            radiantTeamAdapter = MatchInfoPlayerAdapter()
            adapter = radiantTeamAdapter
        }
        with(binding.direTeamPlayers) {
            direTeamAdapter = MatchInfoPlayerAdapter()
            adapter = direTeamAdapter
        }
    }


}