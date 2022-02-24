package com.example.dota2stats.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dota2stats.R
import com.example.dota2stats.databinding.ActivityLogoBinding


class LogoActivity : AppCompatActivity() {
    val DURATION: Long = 1500
    val ALPHA: Float = 1f
    private lateinit var binding: ActivityLogoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.logo.alpha = 0f
        binding.logo.animate().setDuration(DURATION).alpha(ALPHA).withEndAction {
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}