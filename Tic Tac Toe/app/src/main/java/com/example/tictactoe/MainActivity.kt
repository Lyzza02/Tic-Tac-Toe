package com.example.tictactoe

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide() //hide action bar

        val btn_start = findViewById<Button>(R.id.btn_play_now)
        btn_start.setOnClickListener {
            //going to the next acivity
            val intent = Intent(this,Player_info::class.java)
            startActivity(intent)
        }

        val btn_about = findViewById<Button>(R.id.btn_about)
        btn_about.setOnClickListener {
            val intent = Intent(this,AboutUs::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        //Dialog box
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you going to exit?")
        builder.setIcon(R.drawable.ic_action_warning)

        builder.setPositiveButton("Ok", DialogInterface.OnClickListener{ dialog, which ->
            finishAffinity()
        })

        builder.setNegativeButton("Cancel", DialogInterface.OnClickListener{ dialog, which ->
            dialog.dismiss()
        })

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}