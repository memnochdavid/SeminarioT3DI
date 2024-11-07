package com.example.seminariot3di

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ej06_03Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej06032)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var lista=mutableListOf<String>("perro", "gato", "pez", "pajaro")

        var recibe=findViewById<TextView>(R.id.recibe_elemento)
        var elemento_recibido=intent.getStringExtra("nuevo").toString()
        lista.add(elemento_recibido)

        recibe.text="La lista:\n"+lista.toString()
    }
}