package com.example.seminariot3di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ej06Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej06)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var boton06_01=findViewById<AppCompatButton>(R.id.boton06_01)
        var boton06_02=findViewById<AppCompatButton>(R.id.boton06_02)
        var boton06_03=findViewById<AppCompatButton>(R.id.boton06_03)
        var boton06_04=findViewById<AppCompatButton>(R.id.boton06_04)

        boton06_01.setOnClickListener {
            val intent= Intent(this@Ej06Activity,Ej06_01Activity::class.java)
            startActivity(intent)
        }

        boton06_02.setOnClickListener {
            val intent= Intent(this@Ej06Activity,Ej06_02Activity::class.java)
            startActivity(intent)
        }


        boton06_03.setOnClickListener {
            val intent= Intent(this@Ej06Activity,Ej06_03Activity::class.java)
            startActivity(intent)
        }

        boton06_04.setOnClickListener {
            val intent= Intent(this@Ej06Activity,Ej06_04Activity::class.java)
            startActivity(intent)
        }

    }
}