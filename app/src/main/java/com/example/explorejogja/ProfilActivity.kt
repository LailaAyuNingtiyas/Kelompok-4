package com.example.explorejogja

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        val email = intent.getStringExtra(MasukActivity.DATA_EMAIL)
        val pass = intent.getStringExtra(MasukActivity.DATA_PASS)
        val db = DataHelper(this)
        val logOut = findViewById<Button>(R.id.btnLogOut)
        val editProfil = findViewById<Button>(R.id.btnEditProfil)
        val namaProfil = findViewById<TextView>(R.id.namaUser)
        val emailProfil = findViewById<TextView>(R.id.emailUser)
        var nama : String = ""
        val cursor : Cursor
        val database = db.readableDatabase
        cursor = database.rawQuery("SELECT * FROM user WHERE email = '$email'", null)
        cursor.moveToFirst()
        if (cursor.count > 0) {
            cursor.moveToPosition(0)
            namaProfil.text = cursor.getString(1).toString()
            emailProfil.text = cursor.getString(2).toString()
            nama = cursor.getString(1).toString()
        }

        val checkSession = db.checkSession("Empty")
        if(checkSession){
            val intent = Intent(this, MasukActivity::class.java)
            startActivity(intent)
        }

        logOut.setOnClickListener {
            val updateSession = db.upgradeSession("ada", 1)
            if(updateSession){
                Toast.makeText(applicationContext, "Berhasil Logout", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MasukActivity::class.java)
                startActivity(intent)
            }
        }

        editProfil.setOnClickListener{
            val intent = Intent(this, EditProfilActivity::class.java)
                .putExtra("email", email).putExtra("nama", nama).putExtra("pass", pass)
            startActivity(intent)
        }

        val btnKembalikemenu = findViewById<ImageView>(R.id.kembalikemenu)
        btnKembalikemenu.setOnClickListener {
            val intent = Intent(this@ProfilActivity, MenuActivity::class.java)
            startActivity(intent)
        }

    }
}