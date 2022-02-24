package com.example.dota2stats.presentation.playerProfile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dota2stats.databinding.FragmentPlayerProfileBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.picasso.transformations.CropCircleTransformation
import javax.inject.Inject

@AndroidEntryPoint
class PlayerProfileFragment : Fragment() {
    private lateinit var binding: FragmentPlayerProfileBinding
    private lateinit var viewModel: PlayerProfileViewModel
    private lateinit var recyclerAdapter: RecentMatchesAdapter

    @Inject
    lateinit var profileFactory: PlayerProfileViewModelFactory
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

            viewModel.winrate.observe(this, { wr ->
                binding.profileWins.text = "Win: ${wr.win}"
                binding.profileLoses.text = "Lose: ${wr.lose}"
                val winrate = calculateWinrate(wr.win, wr.lose)
                binding.profileWinrate.text = "Winrate: $winrate%"

                viewModel.recentMatches.observe(this, { rm ->
                    recyclerAdapter.submitList(rm)
                    if (rm.isNotEmpty()) {
                        binding.progressBar.visibility = View.GONE
                        binding.profileLayout.visibility = View.VISIBLE
                    }
                })
            })
        })

        return binding.root
    }


    private fun setupViewModel() {
        val arguments = PlayerProfileFragmentArgs.fromBundle(requireArguments())
        viewModel =
            ViewModelProvider(this, profileFactory)[PlayerProfileViewModel::class.java]
        viewModel.account_id = arguments.accountId
        viewModel.getProfile()
    }

    private fun setupRecycler() {
        with(binding.recentRecycler) {
            recyclerAdapter = RecentMatchesAdapter(this@PlayerProfileFragment)
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