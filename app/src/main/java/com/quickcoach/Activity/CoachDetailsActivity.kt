package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.databinding.ActivityCoachDetailsBinding

class CoachDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}