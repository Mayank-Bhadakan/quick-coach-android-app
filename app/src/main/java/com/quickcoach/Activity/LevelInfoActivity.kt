package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.databinding.ActivityLevelInfoBinding

class LevelInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLevelInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}