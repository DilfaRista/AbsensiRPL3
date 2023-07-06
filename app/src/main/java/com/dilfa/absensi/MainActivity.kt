package com.dilfa.absensi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
            val intent = Intent(this, BuatAbsensi::class.java)
            startActivity(intent)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener{
            val intent = Intent(this, AbsenActivity::class.java)
            startActivity(intent)
        }
    }
}