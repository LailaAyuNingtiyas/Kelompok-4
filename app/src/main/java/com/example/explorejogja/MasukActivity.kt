package com.example.explorejogja

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MasukActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)
        Log.v(TAG, "Activity Status : start MasukActivity")
        val db = DataHelper(this)
        val email = findViewById<EditText>(R.id.Masukemail)
        val pass = findViewById<EditText>(R.id.Masukpassword)
        val btnLoginMenu = findViewById<Button>(R.id.btnmasukmenu)
        btnLoginMenu.setOnClickListener {
            val strEmail = email.text.toString()
            val strPass = pass.text.toString()
            val masuk = db.checkLogin(strEmail, strPass)
            if (masuk){
                val updateSession = db.upgradeSession("ada", 1)
                if (updateSession){
                    Toast.makeText(applicationContext,"Berhasil Masuk", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MenuActivity::class.java).putExtra(
                        DATA_EMAIL, strEmail
                    ).putExtra(DATA_PASS, strPass)
                    startActivity(intent)
                }
            }else{
                Toast.makeText(
                    applicationContext,
                    "Email dan atau Password Salah",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        val btnKembalikeawal = findViewById<ImageView>(R.id.kembalikeawal)
        btnKembalikeawal.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val btnDaftarsini = findViewById<TextView>(R.id.daftarsini)
        btnDaftarsini.setOnClickListener{
            val intent = Intent(this, DaftarActivity::class.java)
            startActivity(intent)
        }
    }

    companion object {
        const val TAG = "MasukActivity"
        const val DATA_EMAIL = "DATA_EMAIL"
        const val DATA_PASS = "DATA_PASS"
    }
}