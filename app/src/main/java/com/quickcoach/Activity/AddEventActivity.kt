package com.quickcoach.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.quickcoach.databinding.ActivityAddEventBinding

class AddEventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddEventBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}