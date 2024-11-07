package com.example.seminariot3di

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ej06_04Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej06042)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var nombre_pais=findViewById<TextView>(R.id.nombre_pais)
        var bandera=findViewById<ImageView>(R.id.bandera)
        var n_hab=findViewById<TextView>(R.id.n_hab)
        val pais = intent.getParcelableExtra<Pais>("pais")
        if (pais != null) {
            nombre_pais.text = pais.nombre
            bandera.setImageResource(pais.bandera)
            n_hab.text = pais.habitantes.toString()+" habitantes"
        }

    }
}