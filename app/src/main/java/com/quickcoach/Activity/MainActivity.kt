package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.R
import com.quickcoach.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inti()
    }

    private fun inti() {

        binding.customHeader.setTitle(R.string.login)
        binding.customHeader.iconVisible(true)
        binding.customHeader.backButtonVisibile(true)

    }
}