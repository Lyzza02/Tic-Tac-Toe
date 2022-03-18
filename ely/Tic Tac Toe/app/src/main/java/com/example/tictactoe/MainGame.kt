package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game)
    }

    fun clickPlayAgain(view: View){

    }

    fun backHome(view: View){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

    fun buClick(view: View){
        val btn: Button = view as Button
        var cell_ID = 0
        when(btn.id){
            R.id.button00 -> cell_ID = 1
            R.id.button01 -> cell_ID = 2
            R.id.button02 -> cell_ID = 3

            R.id.button10 -> cell_ID = 4
            R.id.button11 -> cell_ID = 5
            R.id.button12 -> cell_ID = 6

            R.id.button20 -> cell_ID = 7
            R.id.button21 -> cell_ID = 8
            R.id.button22 -> cell_ID = 9
        }

        Log.d("buClick:", btn.id.toString())
        Log.d("buClick:", cell_ID.toString())
    }
}