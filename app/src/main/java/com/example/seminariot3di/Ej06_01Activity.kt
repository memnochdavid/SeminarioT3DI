package com.example.seminariot3di

import android.os.Bundle
import android.widget.ImageView
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
    private var n_turno=0//turno del juego
    private lateinit var reset: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej0601)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //botón reiniciar
        reset=findViewById(R.id.restart)
        reset.setOnClickListener {
            recreate()
        }
        //lógica del tablero
        var tableroBool = arrayOf(
            arrayOf(false, false, false),
            arrayOf(false, false, false),
            arrayOf(false, false, false)
        )
        //inicialización de la vista
        binding= ActivityEj0601Binding.inflate(layoutInflater)
        val tableroIMG = listOf(
            R.id.cero_cero, R.id.uno_cero, R.id.dos_cero,
            R.id.cero_uno, R.id.uno_uno, R.id.dos_uno,
            R.id.cero_dos, R.id.uno_dos, R.id.dos_dos
        )
        //partida
        var index = 0
        for (i in 0..2) {
            for (j in 0..2) {
                val casilla = tableroIMG[index]
                val casillaImagen = findViewById<AppCompatImageButton>(casilla)
                casillaImagen.setOnClickListener {

                    casillaImagen.setImageResource(R.drawable.circulo)
                    tableroBool[i][j] = true
                    n_turno++

                    //turno CPU
                    if (n_turno % 2 == 1) {//se asegura que el turno sea de la CPU
                        //se actualiza el tablero con la jugada de la CPU
                        tableroBool=turnoCPU(tableroBool,tableroIMG)
                        n_turno++
                    }
                }
                index++
            }
        }

        //falta implementar el ganador







    }
    //acciones de la CPU - recibe el tablero y devuelve el tablero actualizado
    //sólo busca posiciones en tableroBool que sean false y las cambia a true
    //y actualiza la imagen del tableroIMG correspondiente
    fun turnoCPU(tableroBool: Array<Array<Boolean>>,tableroIMG:List<Int>): Array<Array<Boolean>>{
        var tableroBool2=tableroBool
        var casillasLibres= mutableListOf<Int>()
        for (i in 0..2) {
            for (j in 0..2) {
                if(tableroBool[i][j]==false){
                    casillasLibres.add(i*3+j)
                }
            }
        }
        var casillaCPU=casillasLibres.random()
        var i=casillaCPU/3
        var j=casillaCPU%3
        tableroBool2[i][j]=true
        val casillaImagen = findViewById<AppCompatImageButton>(tableroIMG[casillaCPU])
        casillaImagen.setImageResource(R.drawable.x)
        return tableroBool2
    }


}