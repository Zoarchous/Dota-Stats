package com.example.dota2stats.presentation.playerProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dota2stats.databinding.FragmentPlayerProfileBinding
import com.example.dota2stats.presentation.MainActivity
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.CropCircleTransformation

class PlayerProfileFragment : Fragment() {
    private lateinit var binding: FragmentPlayerProfileBinding
    private lateinit var viewModel: PlayerProfileViewModel
    private lateinit var recyclerAdapter: RecentMatchesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerProfileBinding.inflate(inflater)
        setupViewModel()
        setupRecycler()
        viewModel.profile.observe(this, {
            Picasso.get()
                .load(it.avatarfull)
                .transform(CropCircleTransformation())
                .into(binding.profileAvatar)
            binding.profileNickname.text = it.personaname

        })
        viewModel.recentMatches.observe(this, {
            recyclerAdapter.submitList(it)
            if (it.isNotEmpty()) {
                binding.progressBar.visibility = View.GONE
                binding.profileLayout.visibility = View.VISIBLE
            }
        })
        viewModel.winrate.observe(this, {
            binding.profileWins.text = "Win: ${it.win}"
            binding.profileLoses.text = "Lose: ${it.lose}"
            val winrate = calculateWinrate(it.win, it.lose)
            binding.profileWinrate.text = "Winrate: $winrate%"
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun setupViewModel() {
        val arguments = PlayerProfileFragmentArgs.fromBundle(requireArguments())
        viewModel = ViewModelProvider(activity as MainActivity)[PlayerProfileViewModel::class.java]
        viewModel.account_id = arguments.accountId
        viewModel.getProfile()
    }

    private fun setupRecycler() {
        with(binding.recentRecycler) {
            recyclerAdapter = RecentMatchesAdapter(activity as MainActivity)
            adapter = recyclerAdapter
        }
        setupClickListener()
    }

    private fun setupClickListener() {
        recyclerAdapter.onRecentMatchItemClickListener = {
            this.findNavController().navigate(
                PlayerProfileFragmentDirections
                    .actionPlayerProfileFragmentToMatchInfoFragment(it.match_id)
            )
        }
    }

    private fun calculateWinrate(a: Int, b: Int): String {
        val average = a + b
        val winrate = (a * 100) / average.toDouble()
        return String.format("%.2f", winrate)
    }

}