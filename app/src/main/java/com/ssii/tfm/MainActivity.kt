package com.ssii.tfm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnUniversidad.setOnClickListener{eligeUbicacion(btnUniversidad.text.toString())}
        btnEstacion.setOnClickListener { eligeUbicacion(btnEstacion.text.toString()) }
        btnParque.setOnClickListener { eligeUbicacion(btnParque.text.toString()) }
    }

    fun eligeUbicacion(btnText : String) {
        val bundle = intent.extras
        val modo = bundle.getString("modo")
        val intent = Intent(this@MainActivity, AprendizajeActivity::class.java)
        intent.putExtra("ubicacion", btnText)
        intent.putExtra("modo", modo)
        println(btnText)
        startActivity(intent)
    }

}
