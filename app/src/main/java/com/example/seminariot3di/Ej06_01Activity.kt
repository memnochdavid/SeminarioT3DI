package com.example.seminariot3di

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.seminariot3di.databinding.ActivityEj0601Binding
import kotlin.random.Random
import kotlin.random.nextInt

class Ej06_01Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEj0601Binding
    private var n_turno = 0 //turno del juego

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEj0601Binding.inflate(layoutInflater)
        setContentView(binding.root) // Set content view using binding.root
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets -> // Use binding.root
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //botón reiniciar
        binding.restart.setOnClickListener {
            recreate()
        }

        var tablero = MutableList(9) { false }
        var checkTableroPlayer = MutableList(9) { false }
        var checkTableroCPU = MutableList(9) { false }

        var tableroIMG = listOf(
            binding.ceroCero, binding.unoCero, binding.dosCero,
            binding.ceroUno, binding.unoUno, binding.dosUno,
            binding.ceroDos, binding.unoDos, binding.dosDos
        )
        var fin_juego=false
        //comienza el juego

        //turno jugador
        tableroIMG.forEachIndexed { index, boton ->
            boton.setOnClickListener {
                if (n_turno % 2 == 0 && !checkTableroPlayer[index] && !checkTableroCPU[index] && !fin_juego) {
                    boton.setImageResource(R.drawable.circulo)
                    tablero[index] = true
                    checkTableroPlayer[index] = true
                    if (victoria(checkTableroPlayer)) {
                        binding.victoria.text = "Victoria jugador"
                        binding.victoria.visibility = VISIBLE
                        fin_juego=true
                    }
                    n_turno++
                }
                //turno CPU
                if (n_turno < 9 && n_turno % 2 != 0 && !fin_juego) {
                    fin_juego=turnoCPU(tableroIMG,tablero,checkTableroCPU)
                }
            }
        }



    }
    fun turnoCPU(tableroIMG: List<AppCompatImageButton>, tablero: MutableList<Boolean>, checkTableroCPU: MutableList<Boolean>):Boolean{
        val availableMoves = tableroIMG.indices.filter { !tablero[it] }
        var victoria=false
        if (availableMoves.isNotEmpty()) {
            val randomIndex = availableMoves.random()
            tableroIMG[randomIndex].setImageResource(R.drawable.x)
            tablero[randomIndex] = true
            checkTableroCPU[randomIndex] = true
            if (victoria(checkTableroCPU)) {
                binding.victoria.text = "Victoria CPU"
                binding.victoria.visibility = VISIBLE
                victoria=true
            }
            n_turno++
        }
        return victoria
    }

    fun victoria(checkTablero: MutableList<Boolean>):Boolean{
        //comprueba horizontal
        var victoria=false
        //comprueba horizontales
        //fila cero
        if(checkTablero[0]==checkTablero[1] && checkTablero[1]==checkTablero[2] && checkTablero[0]==true){
            victoria=true
        }
        //fila uno
        if(checkTablero[3]==checkTablero[4] && checkTablero[4]==checkTablero[5] && checkTablero[3]==true){
            victoria=true
        }
        //fila dos
        if(checkTablero[6]==checkTablero[7] && checkTablero[7]==checkTablero[8] && checkTablero[6]==true){
            victoria=true
        }
        //comprueba vertical
        //col 0
        if(checkTablero[0]==checkTablero[3] && checkTablero[3]==checkTablero[6] && checkTablero[0]==true){
            victoria=true
        }
        //col1
        if(checkTablero[1]==checkTablero[4] && checkTablero[4]==checkTablero[7] && checkTablero[1]==true){
            victoria=true
        }
        //col2
        if(checkTablero[2]==checkTablero[5] && checkTablero[5]==checkTablero[8] && checkTablero[2]==true){
            victoria=true
        }
        //comprueba diagonal
        //diag 1
        if(checkTablero[0]==checkTablero[4] && checkTablero[4]==checkTablero[8] && checkTablero[0]==true){
            victoria=true
        }
        //diag 2
        if(checkTablero[6]==checkTablero[4] && checkTablero[4]==checkTablero[2] && checkTablero[6]==true){
            victoria=true
        }
        return victoria
    }

}