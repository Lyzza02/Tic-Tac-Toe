package com.example.tictactoe

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Player_info : AppCompatActivity() {
    var duration = Toast.LENGTH_SHORT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_info)

        supportActionBar?.hide() //hide action bar

        val btn_start = findViewById<Button>(R.id.btn_submit)
        btn_start.setOnClickListener {
            checking()
        }
    }

    private fun checking(){
        var p1 = findViewById<EditText>(R.id.player1_name)
        var p2 = findViewById<EditText>(R.id.player2_name)

        //check if it is not empty
        if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
            Toast.makeText(applicationContext,  "Empty field not allowed!", duration).show();
        } else {
            //going to the next acivity (Main Game)
            val intent = Intent(this,MainGame::class.java)
            //pass the names of the play to MainGame
            intent.putExtra("p1_name",p1.getText().toString())
            intent.putExtra("p2_name",p2.getText().toString())
            startActivity(intent)
            finish()
        }
    }

    override fun onBackPressed() {
        //Dialog box
        finish()
    }
}