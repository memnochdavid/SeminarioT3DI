package com.example.seminariot3di

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seminariot3di.databinding.ActivityEj06022Binding

class Ej06_02Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej06022)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var recibe=findViewById<TextView>(R.id.recibe)
        var nombre_recibido=intent.getStringExtra("nombre")
        var numero_recibido=intent.getStringExtra("numero")

        recibe.text="RECIBIDO\nNombre: "+nombre_recibido+"\n"+"Número: "+numero_recibido

    }
}