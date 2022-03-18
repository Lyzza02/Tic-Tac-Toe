package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Player_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_info)

        val btn_start = findViewById<Button>(R.id.submit)
        btn_start.setOnClickListener {
            //going to the next acivity (Main Game)
            val intent = Intent(this,MainGame::class.java)
            startActivity(intent)
        }
    }
}