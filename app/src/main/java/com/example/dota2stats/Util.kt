package com.example.dota2stats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dota2stats.data.remoteModel.ApiRequest
import com.example.dota2stats.domain.constants.Hero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun formatTime(duration: Int): String {
    var time = duration
    val minutes = time / 60
    time %= 60
    val seconds = time

    val timeString: String = if (seconds >= 10) {
        "$minutes:$seconds"
    } else {
        "$minutes:0$seconds"
    }
    return timeString
}

fun showGameMode(mode: Int): String {
    return when (mode) {
        0 -> "Unknown"
        1 -> "All Pick"
        2 -> "Captains Mode"
        3 -> "Random Draft"
        4 -> "Single Draft"
        5 -> "All Random"
        6 -> "Intro"
        7 -> "Diretide"
        8 -> "Reverse CM"
        9 -> "Greeviling"
        10 -> "Tutorial"
        11 -> "Mid Only"
        12 -> "Least Played"
        13 -> "Limited Heroes"
        14 -> "Compendium Match"
        15 -> "Custom"
        16 -> "Captains Draft"
        17 -> "Balanced Draft"
        18 -> "Ability Draft"
        19 -> "Event"
        20 -> "AR DeathMatch"
        21 -> "1vs1 Mid"
        22 -> "All Pick"
        23 -> "Turbo"
        24 -> "Mutation"
        else -> "Unknown"
    }
}

fun findHero(heroId: Int): Int {
    val heroPosition = when {
        heroId <= 23 -> {
            heroId - 1
        }
        heroId <= 114 -> {
            heroId - 2
        }

        heroId <= 121 -> {
            heroId - 6
        }
        heroId == 123 -> {
            heroId - 7
        }
        heroId == 126 -> {
            heroId - 9
        }
        heroId <= 129 -> {
            heroId - 10
        }
        else -> {
            heroId - 15
        }
    }
    return heroPosition
}

