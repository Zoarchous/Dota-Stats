package com.example.dota2stats.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
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
import com.example.dota2stats.presentation.proPlayers.ProPlayersViewModel
import com.example.dota2stats.presentation.proPlayers.ProPlayersViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment

        navController = navHostFragment.navController

        setupActionBarWithNavController(navController, binding.drawerLayout)

        binding.toolbar.setupWithNavController(navController, binding.drawerLayout)

        binding.navView.setupWithNavController(navController)
    }



    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, navController)||
                super.onOptionsItemSelected(item)
    }

}