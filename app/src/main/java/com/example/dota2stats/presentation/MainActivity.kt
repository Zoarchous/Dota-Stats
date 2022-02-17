package com.example.dota2stats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.presentation.matchInfo.MatchInfoViewModel
import com.example.dota2stats.presentation.matchInfo.MatchInfoViewModelFactory
import com.example.dota2stats.presentation.proMatches.ProMatchesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    private lateinit var mainViewModel: MainViewModel
    private lateinit var matchViewModel: MatchInfoViewModel
    @Inject lateinit var matchFactory: MatchInfoViewModelFactory
    @Inject lateinit var mainFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController
        mainViewModel =
            ViewModelProvider(this, mainFactory)[MainViewModel::class.java]

        matchViewModel =
            ViewModelProvider(this, matchFactory)[MatchInfoViewModel::class.java]
    }

}