package com.example.myapplication.activities

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.R
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.firebase.database.getValue
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

        val nome = findViewById<EditText>(R.id.textnome)
        val email = findViewById<EditText>(R.id.textemail)
        val senha = findViewById<EditText>(R.id.textsenha)
        val confsenha = findViewById<EditText>(R.id.confirsenha)

        val btn: Button = findViewById(R.id.butsignin)

        btn.setOnClickListener{
            val email = findViewById<EditText>(R.id.textemail).text.toString()
            val senha = findViewById<EditText>(R.id.textsenha).text.toString()
            val confsenha = findViewById<EditText>(R.id.confirsenha).text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty() && confsenha.isNotEmpty()) {

                if (senha == confsenha) {

                    firebaseAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, Inicial::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else {
                    Toast.makeText(this, "A senha não corresponde", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Campos vazios não são permitidos!!", Toast.LENGTH_SHORT).show()




            }
        }
    }
}