package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.databinding.ActivityEventInfoBinding

class EventInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}