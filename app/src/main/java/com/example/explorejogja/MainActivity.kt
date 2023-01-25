package com.example.explorejogja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnMasuk = findViewById<Button>(R.id.masukLogin)
        val btnDaftar = findViewById<Button>(R.id.daftar)
        btnMasuk.setOnClickListener{
            val intent = Intent(this, MasukActivity::class.java)
            startActivity(intent)
        }
        btnDaftar.setOnClickListener {
            val intent = Intent(this, DaftarActivity::class.java)
            startActivity(intent)
        }
    }
}