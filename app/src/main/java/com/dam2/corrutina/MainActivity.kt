package com.dam2.corrutina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
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

        // 'launch' se encarga de crear una corrutina Task
        // vamos a poder identificarla con 'job'
        val job = GlobalScope.launch(Dispatchers.Main) {
            // llamamos a una funcion que estara dentro de la corrutina
            // en esta funcion habrá un delay()
            suspendingTask(miTexto)
            }

        // añadimos otra corrutina Task2 identificada como job2
        val job2 = GlobalScope.launch(Dispatchers.Main) {
            suspendingTask2(miTexto)
        }
    }

    // segunda Tarea Task2
    // se ejecuta en paralelo con la primera Task
    suspend fun suspendingTask2(miTexto: TextView) {
        // espero 1,5sg
        delay(1500L)
        miTexto.text = "TASK 2"
    }

    // la declaramos 'suspend' porque tendrá un Delay
    suspend fun suspendingTask(miTexto: TextView) {
        miTexto.text = "Corrutina"
        // paramos 3sg la corrutina pero no la UI principal
        delay(3000L)
        miTexto.text = "Hello Coroutine!"
    }
}