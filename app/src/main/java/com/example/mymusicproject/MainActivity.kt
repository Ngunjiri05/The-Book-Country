package com.example.mymusicproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var BtnStart: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        BtnStart = findViewById(R.id.mBtnStart)

        BtnStart.setOnClickListener {
            var intent = Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }
}