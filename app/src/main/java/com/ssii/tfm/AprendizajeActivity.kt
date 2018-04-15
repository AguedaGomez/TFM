package com.ssii.tfm

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_aprendizaje.*

class AprendizajeActivity : AppCompatActivity() {
    var modo : String = ""
    var ubicacion : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aprendizaje)
        nombreImagen.visibility = View.INVISIBLE
        siguienteImg.setOnClickListener{elegirConcepto(ubicacion)}
        evaluacion.setOnClickListener{irAEvaluacion()}
        imgBoton.setOnClickListener{mostrarNombre()}
        comprobarModo()
    }

    fun comprobarModo() {
        val bundle = intent.extras
        modo = bundle.getString("modo")
        eligeUbicacion(modo)
    }

    fun eligeUbicacion(modo : String) {
        if (modo == "Localizacion") {
            val bundle = intent.extras
            ubicacion = bundle.getString("ubicacion")
        }
        else ubicacion = "aleatoria"
        elegirConcepto(ubicacion)
    }

    fun elegirConcepto (lugar : String) {
        nombreImagen.visibility = View.INVISIBLE
       val concepto = AprendizajeModel.eligeUbicacion(lugar)
        mostrarConcepto(concepto.first, concepto.second)
    }

    fun mostrarConcepto (nombre : String, img : Int) {
        nombreImagen.text = nombre
        imgBoton.background = ContextCompat.getDrawable(applicationContext, img)
    }

    fun mostrarNombre () {
        nombreImagen.visibility = View.VISIBLE
    }

    fun irAEvaluacion() {
        val intent = Intent(this@AprendizajeActivity, EvaluacionActivity::class.java)
        intent.putExtra("ubicacion", ubicacion)
        intent.putExtra("modo", modo)
        startActivity(intent)
    }

}
