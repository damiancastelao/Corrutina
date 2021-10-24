package com.dam2.corrutina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val miBoton: Button = findViewById(R.id.miBoton)

        // declaramos el listener del boton
        miBoton.setOnClickListener {
            // llamamos a una funcion que lanzara la corrutina
            lanzarCorrutina()
        }

    }
    // declaramos la funcion que lanzara la corrutina
    private fun lanzarCorrutina() {
        val miTexto: TextView = findViewById(R.id.miTextView)

        // 'launch' se encarga de crear una corrutina
        // vamos a poder identificarla con 'job'
        val job = GlobalScope.launch(Dispatchers.Main) {

        }
    }

}