package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.databinding.ActivityCoachInformationBinding

class CoachInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}