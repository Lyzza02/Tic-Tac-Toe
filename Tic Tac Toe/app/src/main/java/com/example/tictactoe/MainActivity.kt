package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_start = findViewById<Button>(R.id.play_now_btn)
        btn_start.setOnClickListener {
            //going to the next acivity
            val intent = Intent(this,Player_info::class.java)
            startActivity(intent)
        }
    }
}