package com.quickcoach.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.quickcoach.R
import com.quickcoach.databinding.ActivitySplashBinding
import com.quickcoach.utils.Pref

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var START_SCREEN = 2000

        initView()
    }

    private fun initView() {

        Handler(Looper.getMainLooper()).postDelayed({
               startActivity(Intent(this , WelcomeActivity::class.java))
        } , 2000)

    }
}