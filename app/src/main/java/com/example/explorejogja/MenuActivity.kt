package com.example.explorejogja

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val db = DataHelper(this)
        val checkSession = db.checkSession("Empty")
        val wisataAlam = findViewById<ImageView>(R.id.alam)
        val kulinerOren = findViewById<ImageView>(R.id.kulineroren)
        val hotelOren = findViewById<ImageView>(R.id.hoteloren)
        val religiOren = findViewById<ImageView>(R.id.religioren)
        val buttonProfile = findViewById<ImageView>(R.id.buttonakun)
        if (checkSession){
            val intent = Intent(this, MasukActivity::class.java)
            startActivity(intent)
        }
        wisataAlam.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        kulinerOren.setOnClickListener {
            val intent = Intent(this, KulinerActivity::class.java)
            startActivity(intent)
        }
        hotelOren.setOnClickListener {
            val intent = Intent(this, HotelActivity::class.java)
            startActivity(intent)
        }
        religiOren.setOnClickListener {
            val intent = Intent(this, ReligiActivity::class.java)
            startActivity(intent)
        }
        buttonProfile.setOnClickListener {
            val email = intent.getStringExtra(MasukActivity.DATA_EMAIL)
            val pass = intent.getStringExtra(MasukActivity.DATA_PASS)
            val intent = Intent(applicationContext, ProfilActivity::class.java)
                .putExtra(MasukActivity.DATA_EMAIL, email).putExtra(MasukActivity.DATA_PASS, pass)
            startActivity(intent)
        }
    }
}