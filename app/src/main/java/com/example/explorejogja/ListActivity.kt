package com.example.explorejogja

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val bukitLintangSewu = findViewById<TextView>(R.id.btnlintangsewu)
        val btnKembalikemenu = findViewById<ImageView>(R.id.kembalikemenu)
        val tesss = findViewById<ImageView>(R.id.tesss)
        bukitLintangSewu.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        btnKembalikemenu.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
       tesss.setOnClickListener {
            val intent = Intent(this, DetailWisataActivity::class.java)
            startActivity(intent)

        }
    }
}