package com.example.liongames

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)
        val timer = object : CountDownTimer(2000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent (this@LoadingActivity, MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }
        timer.start()
    }
}