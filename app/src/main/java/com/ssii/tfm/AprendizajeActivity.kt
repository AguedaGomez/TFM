package com.ssii.tfm

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ssii.tfm.AprendizajeModel.comprobarNumeroConceptosEnseniados
import com.ssii.tfm.AprendizajeModel.conceptosEnseniados
import com.ssii.tfm.AprendizajeModel.guardarConceptoEnseniado
import com.ssii.tfm.AprendizajeModel.guardarPalabraConocida
import kotlinx.android.synthetic.main.activity_aprendizaje.*

class AprendizajeActivity : AppCompatActivity() {
    var modo : String = ""
    var ubicacion : String = ""
    var concepto : Pair<String, Int> = Pair("", 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aprendizaje)

        siguienteImg.setOnClickListener{elegirConcepto(ubicacion)}
        evaluacion.setOnClickListener{irAEvaluacion()}
        imgBoton.setOnClickListener{mostrarNombre()}
        okBtn.setOnClickListener{palabraConocida()}
        xBtn.setOnClickListener{esconderPregunta()}

        iniciarComponentes()
        comprobarModo()
    }

    fun iniciarComponentes() {
        nombreImagen.visibility = View.INVISIBLE
        siguienteImg.visibility = View.INVISIBLE
        palabraConocidaPregunta.visibility = View.INVISIBLE
        okBtn.visibility = View.INVISIBLE
        xBtn.visibility = View.INVISIBLE
    }

    fun comprobarModo() {
        val bundle = intent.extras
        modo = bundle.getString("modo")
        eligeUbicacion(modo)
    }

    fun estadoBotonEvaluacion () {
        evaluacion.isEnabled = comprobarNumeroConceptosEnseniados()
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
        siguienteImg.visibility = View.INVISIBLE
        estadoBotonEvaluacion()
        concepto = AprendizajeModel.eligeUbicacion(lugar)
        mostrarConcepto(concepto.first, concepto.second)
    }

    fun mostrarConcepto (nombre : String, img : Int) {
        nombreImagen.text = nombre
        imgBoton.background = ContextCompat.getDrawable(applicationContext, img)
    }

    fun mostrarNombre () {
        nombreImagen.visibility = View.VISIBLE
        println("numero de conceptos enseñados: " + conceptosEnseniados.count())
        if (conceptosEnseniados.find { c -> c.first ==nombreImagen.text.toString()} == null) {
            palabraConocidaPregunta.visibility = View.VISIBLE
            okBtn.visibility = View.VISIBLE
            xBtn.visibility = View.VISIBLE
            guardarConceptoEnseniado(concepto)
        } else esconderPregunta()

    }

    fun irAEvaluacion() {
        val intent = Intent(this@AprendizajeActivity, EvaluacionActivity::class.java)
        intent.putExtra("ubicacion", ubicacion)
        intent.putExtra("modo", modo)
        startActivity(intent)
    }

    fun palabraConocida() {
        guardarPalabraConocida(nombreImagen.text.toString())
        esconderPregunta()
    }

    fun esconderPregunta() {
        palabraConocidaPregunta.visibility = View.INVISIBLE
        okBtn.visibility = View.INVISIBLE
        xBtn.visibility = View.INVISIBLE
        siguienteImg.visibility = View.VISIBLE
    }

}
