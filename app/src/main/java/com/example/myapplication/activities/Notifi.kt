package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class Notifi: AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notificacao)
        textView = findViewById(R.id.textviewData)
        val data = intent.getStringExtra("data")
        textView.setText(data)
    }
}