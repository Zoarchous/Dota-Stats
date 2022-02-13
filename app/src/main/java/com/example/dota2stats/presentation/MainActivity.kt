package com.example.dota2stats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.presentation.proMatches.ProMatchesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var recyclerAdapter: ProMatchesAdapter
    private lateinit var viewModel: MainViewModel
    @Inject lateinit var factory: MainViewModelFactory
    private val scope = CoroutineScope(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_pro_matches)
        setupRecycler()
        setupViewModel()
        viewModel.list.observe(this) {
            recyclerAdapter.submitList(it)
        }

    }
    private fun setupViewModel(){
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        scope.launch {
            viewModel.getProMatches()
        }
    }
    private fun setupRecycler(){
        val recycler = findViewById<RecyclerView>(R.id.proMatchesRecView)
        with(recycler){
            recyclerAdapter = ProMatchesAdapter()
            adapter = recyclerAdapter
        }
    }
}