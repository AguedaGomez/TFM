package com.ssii.tfm

/**
 * Created by Ague on 16/04/2018.
 */
object ClaseEligeUbicacion {

    fun eligeUbicacion(lugar : String) : Pair<String, Int> {
        var conceptoElegido : Pair<String, Int>
        println("en eligeUbicacion del modelo")
        conceptoElegido = when (lugar) {
            "Universidad" -> EleccionAleatoria.elegirConcepto(Vocabulario.getUniversidad())
            "Estacion" -> EleccionAleatoria.elegirConcepto(Vocabulario.getEstacion())
            "Parque" ->  EleccionAleatoria.elegirConcepto(Vocabulario.getParque())
            else -> EleccionAleatoria.elegirConcepto(Vocabulario.getAleatorio())
        }
        return conceptoElegido
    }
}