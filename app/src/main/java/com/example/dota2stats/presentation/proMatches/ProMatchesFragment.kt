package com.example.dota2stats.presentation.proMatches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R
import com.example.dota2stats.databinding.FragmentProMatchesBinding
import com.example.dota2stats.presentation.MainActivity
import com.example.dota2stats.presentation.MainViewModel
import com.example.dota2stats.presentation.MainViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProMatchesFragment : Fragment() {
    private lateinit var binding: FragmentProMatchesBinding
    private lateinit var recyclerAdapter: ProMatchesAdapter
    private lateinit var viewModel: MainViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProMatchesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupViewModel()
        viewModel.list.observe(this){
            recyclerAdapter.submitList(it)
            when (it.isEmpty()){
                true -> binding.progressBar.visibility = View.VISIBLE
                else -> binding.progressBar.visibility = View.GONE
            }
        }

        binding.proMatchesSearchView.setOnQueryTextListener(
            object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    binding.proMatchesSearchView.clearFocus()
                    this@ProMatchesFragment.findNavController().navigate(
                        ProMatchesFragmentDirections
                            .actionProMatchesFragmentToPlayersSearchFragment(query)
                    )
                    return false
                }
                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            })
    }

    private fun setupViewModel(){
        viewModel = ViewModelProvider(activity as MainActivity)[MainViewModel::class.java]
        viewModel.getProMatches()

    }
    private fun setupRecycler(){
        with(binding.proMatchesRecView){
            recyclerAdapter = ProMatchesAdapter()
            adapter = recyclerAdapter
        }
        setupItemClickListener()
    }
    private fun setupItemClickListener(){
        recyclerAdapter.onProMatchClickListener = {
            this.findNavController().navigate(
                ProMatchesFragmentDirections
                    .actionProMatchesFragmentToMatchInfoFragment(it.match_id)
            )

        }
    }
}