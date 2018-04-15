package com.ssii.tfm

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_evaluacion.*

class EvaluacionActivity : AppCompatActivity() {

    var conceptoAEvaluar: Pair<String,Int> = ("" to -1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evaluacion)
        op1.setOnClickListener{comprobarRespuesta(op1.text.toString(), op1)}
        op2.setOnClickListener{comprobarRespuesta(op2.text.toString(), op2)}
        op3.setOnClickListener{comprobarRespuesta(op3.text.toString(), op3)}
        recuperarVariables()
    }

    fun recuperarVariables() {
        val bundle = intent.extras
        val mode = bundle.getString("modo")
        if (mode == "Nolocation") conceptoAEvaluar = EvaluacionModel.elegirConceptoCorrecto("aleatorio")
        else conceptoAEvaluar = EvaluacionModel.elegirConceptoCorrecto(bundle.getString("ubicacion"))
        mostrarConcepto()
    }

    fun mostrarConcepto() {
        imagen.setImageResource(conceptoAEvaluar.second)
        op1.text = conceptoAEvaluar.first
        val erroneo1 = EvaluacionModel.elegirConceptoErroneo1(conceptoAEvaluar)
        op2.text = erroneo1.first
        op3.text = EvaluacionModel.elegirConceptoErroneo2(conceptoAEvaluar, erroneo1).first
    }

    fun comprobarRespuesta(opcionElegida : String, idBoton : Button) {
        if (opcionElegida == conceptoAEvaluar.first) idBoton.setBackgroundColor(Color.GREEN)
        else idBoton.setBackgroundColor(Color.RED)
    }
}
