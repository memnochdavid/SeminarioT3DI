package com.example.seminariot3di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class Ej06_03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej0603)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var boton=findViewById<AppCompatButton>(R.id.boton)
        var elemento=findViewById<TextInputEditText>(R.id.formulario_texto_hijo)


        boton.setOnClickListener {
            val intent= Intent(this@Ej06_03Activity,Ej06_03Activity2::class.java)
            val nuevo=elemento.text.toString()
            intent.putExtra("nuevo", nuevo)
            startActivity(intent)
        }
    }
}