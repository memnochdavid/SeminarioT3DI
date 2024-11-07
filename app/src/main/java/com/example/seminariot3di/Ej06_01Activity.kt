package com.example.seminariot3di

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seminariot3di.databinding.ActivityEj0601Binding
import kotlin.random.Random
import kotlin.random.nextInt

class Ej06_01Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEj0601Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej0601)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var tableroBool = arrayOf(
            arrayOf(false, false, false),
            arrayOf(false, false, false),
            arrayOf(false, false, false)
        )


        binding= ActivityEj0601Binding.inflate(layoutInflater)
        val tablero = listOf(
            R.id.cero_cero, R.id.uno_cero, R.id.dos_cero,
            R.id.cero_uno, R.id.uno_uno, R.id.dos_uno,
            R.id.cero_dos, R.id.uno_dos, R.id.dos_dos
        )
        var index = 0
        for (i in 0..2) {
            for (j in 0..2) {
                val casilla = tablero[index]
                val casillaImagen = findViewById<AppCompatImageButton>(casilla)
                casillaImagen.setOnClickListener {
                    casillaImagen.setImageResource(R.drawable.circulo)
                    tableroBool[i][j] = true
                }
                index++
            }
        }



    }


}