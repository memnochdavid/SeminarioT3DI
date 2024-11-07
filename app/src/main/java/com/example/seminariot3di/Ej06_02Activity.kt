package com.example.seminariot3di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seminariot3di.databinding.ActivityEj0602Binding
import com.google.android.material.textfield.TextInputEditText

class Ej06_02Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej0602)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var boton=findViewById<AppCompatButton>(R.id.boton)
        var num=findViewById<TextInputEditText>(R.id.formulario_num_hijo)
        var nom=findViewById<TextInputEditText>(R.id.formulario_nombre_hijo)


        boton.setOnClickListener {
            val intent= Intent(this@Ej06_02Activity,Ej06_02Activity2::class.java)
            val nombre=nom.text.toString()
            val numero=num.text.toString()
            intent.putExtra("nombre", nombre)
            intent.putExtra("numero", numero)
            startActivity(intent)
        }

    }
}