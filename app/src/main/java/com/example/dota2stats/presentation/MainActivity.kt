package com.example.dota2stats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dota2stats.R
import com.example.dota2stats.databinding.ActivityMainBinding
import com.example.dota2stats.domain.proMatches.ProMatchItem
import com.example.dota2stats.presentation.matchInfo.MatchInfoViewModel
import com.example.dota2stats.presentation.matchInfo.MatchInfoViewModelFactory
import com.example.dota2stats.presentation.playerProfile.PlayerProfileViewModel
import com.example.dota2stats.presentation.playerProfile.PlayerProfileViewModelFactory
import com.example.dota2stats.presentation.playersSearch.PlayerSearchViewModel
import com.example.dota2stats.presentation.playersSearch.PlayerSearchViewModelFactory
import com.example.dota2stats.presentation.proMatches.ProMatchesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    private lateinit var playerSearchViewModel: PlayerSearchViewModel
    private lateinit var mainViewModel: MainViewModel
    private lateinit var matchViewModel: MatchInfoViewModel
    private lateinit var profileViewModel: PlayerProfileViewModel
    @Inject lateinit var profileFactory: PlayerProfileViewModelFactory
    @Inject lateinit var playerSearchFactory: PlayerSearchViewModelFactory
    @Inject lateinit var matchFactory: MatchInfoViewModelFactory
    @Inject lateinit var mainFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment
        navController = navHostFragment.navController

        binding.toolbar.setupWithNavController(navController, AppBarConfiguration(navController.graph))

        mainViewModel =
            ViewModelProvider(this, mainFactory)[MainViewModel::class.java]

        matchViewModel =
            ViewModelProvider(this, matchFactory)[MatchInfoViewModel::class.java]

        playerSearchViewModel =
            ViewModelProvider(this, playerSearchFactory)[PlayerSearchViewModel::class.java]

        profileViewModel =
            ViewModelProvider(this, profileFactory)[PlayerProfileViewModel::class.java]
    }

}