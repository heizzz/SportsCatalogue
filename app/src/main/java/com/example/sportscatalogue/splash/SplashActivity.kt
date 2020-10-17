package com.example.sportscatalogue.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.sportscatalogue.R
import com.example.sportscatalogue.home.HomeActivity

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()
        Handler().postDelayed({
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}