package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.databinding.ActivityCoachLevelInfoBinding

class CoachLevelInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachLevelInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachLevelInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}