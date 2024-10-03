package com.pmdm.ieseljust.comptador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var comptador=0
    private val TAG="MainActivity"
    private lateinit var textViewContador:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referencia al TextView
        textViewContador =findViewById<TextView>(R.id.textViewComptador)
        // Referencia al boto d'Open
        val btOpen=findViewById<Button>(R.id.btOpen)

        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.text=comptador.toString() // Estem fent una assignacio directament o accedinta algun metode?

        // Referencia al botó aumentar
        val btAdd=findViewById<Button>(R.id.btAdd)

        // Referencia al botó decrementar
        val btSubtract=findViewById<Button>(R.id.btSubtract)

        // Referencia al botó reinicialitzar
        val btReset=findViewById<Button>(R.id.btReset)

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            textViewContador.text=comptador.toString()
        }

        btSubtract.setOnClickListener{
            comptador--
            textViewContador.text=comptador.toString()
        }

        btReset.setOnClickListener{
            comptador=0
            textViewContador.text=comptador.toString()
        }

        /*btOpen.setOnClickListener{
            val intent = Intent(baseContext, MostraComptadorActivity::class.java)
            intent.putExtra("comptador", comptador)
            startActivity(intent)
        }*/

        btOpen.setOnClickListener {
            Intent(baseContext, MostraComptadorActivity::class.java).apply {
                putExtra("comptador", comptador)
                startActivity(this)
            }
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Comença el mètode onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"Comoença el mètode onResum")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"Comença el mètode onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"Comença el mètode onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"Comença el mètode onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Comença el mètode onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG,"Comença el mètode onSaveInstanceState")
        // Codi per a guardar l'estat

        outState.putInt("Comptador",comptador )
    }

    override fun onRestoreInstanceState(estat: Bundle) {
        super.onRestoreInstanceState(estat)
        Log.d(TAG,"Comença el mètode onRestoreInstanceState")
        // Codi per a guardar l'estat
        comptador=estat.getInt("Comptador")
        textViewContador.text=comptador.toString()
    }



}