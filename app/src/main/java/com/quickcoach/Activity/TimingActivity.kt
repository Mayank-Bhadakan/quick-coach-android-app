package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.databinding.ActivityTimingBinding

class TimingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTimingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}