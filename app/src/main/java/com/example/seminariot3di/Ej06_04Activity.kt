package com.example.seminariot3di

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.versionedparcelable.VersionedParcelize
import kotlinx.parcelize.Parcelize
import com.example.seminariot3di.databinding.ActivityEj0604Binding

class Ej06_04Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej0604)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val spain:Pais = Pais("España", R.drawable.spain,50000000)
        val france:Pais = Pais("Francia", R.drawable.france,67000000)

        val boton_spain=findViewById<AppCompatButton>(R.id.boton_spain)
        val boton_france=findViewById<AppCompatButton>(R.id.boton_france)

        boton_spain.setOnClickListener{
            val intent = Intent(this, Ej06_04Activity2::class.java)
            intent.putExtra("pais", spain)
            startActivity(intent)
        }
        boton_france.setOnClickListener{
            val intent = Intent(this, Ej06_04Activity2::class.java)
            intent.putExtra("pais", france)
            startActivity(intent)
        }


    }
}
@Parcelize
data class Pais(val nombre: String, val bandera: Int, val habitantes: Int):Parcelable