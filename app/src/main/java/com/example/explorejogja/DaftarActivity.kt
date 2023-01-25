package com.example.explorejogja

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DaftarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        val db = DataHelper(this)
        val nama = findViewById<EditText>(R.id.namalengkap)
        val email = findViewById<EditText>(R.id.email)
        val pass = findViewById<EditText>(R.id.password)
        val confPass = findViewById<EditText>(R.id.ulangpassword)
        val sudahDaftar = findViewById <Button>(R.id.Daftarselesai)
        sudahDaftar.setOnClickListener {
            val strNama = nama.text.toString()
            val strEmail = email.text.toString()
            val strPass = pass.text.toString()
            val strConfPass = confPass.text.toString()
            if (strPass == strConfPass){
                val daftar = db.insertUser(strNama, strEmail,strPass)
                if(daftar){
                    if(nama.text.toString().isEmpty()){
                        nama.error = "Nama diperlukan!"
                    }else if(email.text.toString().isEmpty()){
                        email.error = "Email diperlukan!"
                    }else if(pass.text.toString().isEmpty()){
                        pass.error = "Password diperlukan!"
                    }else{
                        Toast.makeText(applicationContext, "Berhasil Mendaftar", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MasukActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }else{
                    Toast.makeText(applicationContext, "Gagal Mendaftar", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(applicationContext, "Password Tidak Cocok", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        val btnKembalikeawal = findViewById<ImageView>(R.id.kembalikeawal)
        btnKembalikeawal.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}