package com.example.dota2stats.presentation.playerProfile

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.R
import com.example.dota2stats.databinding.FragmentPlayerProfileBinding
import com.example.dota2stats.presentation.MainActivity

class PlayerProfileFragment : Fragment() {
    private lateinit var binding: FragmentPlayerProfileBinding
    private lateinit var viewModel: PlayerProfileViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayerProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        viewModel.profile.observe(this,{
            Log.d("!!Prof", it.toString())
        })
    }

    private fun setupViewModel() {
        val arguments = PlayerProfileFragmentArgs.fromBundle(requireArguments())
        viewModel = ViewModelProvider(activity as MainActivity)[PlayerProfileViewModel::class.java]
        viewModel.account_id = arguments.accountId
        viewModel.getProfile()
    }
}