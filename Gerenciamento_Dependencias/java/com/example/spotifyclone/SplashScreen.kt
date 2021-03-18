package com.example.spotifyclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splash.animate().apply {
            duration = 1500
            rotationYBy(360f)
        }.withEndAction {
            splash.animate().apply {
                duration = 1500
                rotationYBy(360f)
            }.withEndAction {
                startApp()
            }
        }.start()
    }

    fun startApp(){
        startActivity(Intent(this@SplashScreen, MainActivity::class.java))
    }
}