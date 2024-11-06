package com.example.seminariot3di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var boton1=findViewById<AppCompatButton>(R.id.button_ej01)
        var boton3=findViewById<AppCompatButton>(R.id.button_ej03)
        var boton4=findViewById<AppCompatButton>(R.id.button_ej04)

        boton1.setOnClickListener {
            val intent= Intent(this@MainActivity,Ej01Activity::class.java)
            startActivity(intent)
        }

        boton3.setOnClickListener {
            val intent= Intent(this@MainActivity,Ej03Activity::class.java)
            startActivity(intent)
        }
/*
        boton4.setOnClickListener {
            val intent= Intent(this@MainActivity,Ej03Activity::class.java)
            startActivity(intent)
        }*/

    }
}