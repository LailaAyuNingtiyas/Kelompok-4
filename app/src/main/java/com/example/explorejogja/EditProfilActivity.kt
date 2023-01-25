package com.example.explorejogja

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)
        val db = DataHelper(this)
        val email = intent.getStringExtra("email")
        val nama = intent.getStringExtra("nama")
        val pass = intent.getStringExtra("pass")
        val editNama = findViewById<EditText>(R.id.namaUser)
        val editEmail = findViewById<EditText>(R.id.emailUser)
        val editPass = findViewById<EditText>(R.id.passUserEdit)
        editEmail.setText(email)
        editNama.setText(nama)
        editPass.setText(pass)
        val submitEdit = findViewById<Button>(R.id.btnSimpan)
        submitEdit.setOnClickListener{
            val updateData = db.updateUser(email, nama, pass)
            if (updateData) {
                Toast.makeText(applicationContext, "Berhasil Update", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Gagal Update", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}