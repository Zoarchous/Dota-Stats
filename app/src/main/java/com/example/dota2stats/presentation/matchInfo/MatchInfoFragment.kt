package com.example.dota2stats.presentation.matchInfo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dota2stats.databinding.FragmentMatchInfoBinding
import com.example.dota2stats.formatTime
import com.example.dota2stats.presentation.MainActivity
import com.example.dota2stats.showGameMode
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MatchInfoFragment : Fragment() {
    private lateinit var binding: FragmentMatchInfoBinding
    private lateinit var viewModel: MatchInfoViewModel
    private lateinit var radiantTeamAdapter: MatchInfoPlayerAdapter
    private lateinit var direTeamAdapter: MatchInfoPlayerAdapter
    @Inject
    lateinit var matchFactory: MatchInfoViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchInfoBinding.inflate(inflater)
        setupViewModel()
        setupRecycler()

        viewModel.matchItem.observe(this, {
            if (it.radiant_win){
                binding.direWin.visibility = View.GONE
            }else{
                binding.radintWin.visibility = View.GONE
            }
            binding.radiantScore.text = it.radiant_score.toString()
            binding.direScore.text = it.dire_score.toString()
            binding.matchDuration.text = formatTime(it.duration)
            binding.gameMode.text = showGameMode(it.game_mode)
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
        viewModel =
            ViewModelProvider(this, matchFactory)[MatchInfoViewModel::class.java]
        viewModel.matchId = arguments.matchId
        viewModel.getPlayersList()
    }

    private fun setupRecycler() {
        with(binding.radiantTeamPlayers) {
            radiantTeamAdapter = MatchInfoPlayerAdapter(this@MatchInfoFragment)
            adapter = radiantTeamAdapter
        }
        with(binding.direTeamPlayers) {
            direTeamAdapter = MatchInfoPlayerAdapter(this@MatchInfoFragment)
            adapter = direTeamAdapter
        }
        setupItemClickListener()
    }

    private fun setupItemClickListener(){
        direTeamAdapter.onPlayerItemClickListener = {
            this.findNavController().navigate(
                MatchInfoFragmentDirections
                    .actionMatchInfoFragmentToPlayerProfileFragment(it.account_id)
            )
        }
        radiantTeamAdapter.onPlayerItemClickListener = {
            this.findNavController().navigate(
                MatchInfoFragmentDirections
                    .actionMatchInfoFragmentToPlayerProfileFragment(it.account_id)
            )
        }
    }
}