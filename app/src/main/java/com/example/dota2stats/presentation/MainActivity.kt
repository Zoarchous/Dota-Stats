package com.example.dota2stats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dota2stats.R
import com.example.dota2stats.domain.proMatches.ProMatchItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    @Inject lateinit var factory: MainViewModelFactory
    private val scope = CoroutineScope(Dispatchers.IO)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        viewModel.list.observe(this, Observer {
            Log.d("!!!List", viewModel.list.value.toString())
        })


    }
    private fun setupViewModel(){
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
        scope.launch {
            viewModel.getProMatches()
        }
    }
}