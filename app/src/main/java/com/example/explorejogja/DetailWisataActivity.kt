package com.example.explorejogja

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DetailWisataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)

        val btnBeliTiket = findViewById<Button>(R.id.belitiket)
        val btnKembaliKeList = findViewById<ImageView>(R.id.kembalikelist)
        val btnMaps = findViewById<ImageButton>(R.id.maps)

        btnBeliTiket.setOnClickListener {
            val intent = Intent(this, TransaksiActivity::class.java)
            startActivity(intent)
        }
        btnKembaliKeList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        btnMaps.setOnClickListener {
            val intent = Intent(this, MapsActivity2::class.java)
            startActivity(intent)
        }
    }
}