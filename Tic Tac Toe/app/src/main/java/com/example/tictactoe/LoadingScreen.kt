package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText

class LoadingScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)

        supportActionBar?.hide()
        val p1:String = intent.getStringExtra("p1_name").toString()
        val p2:String = intent.getStringExtra("p2_name").toString()

        val intent = Intent(this,MainGame::class.java)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            intent.putExtra("p1_name",p1)
            intent.putExtra("p2_name",p2)
            startActivity(intent)
            finish()
        },3000)

    }
}