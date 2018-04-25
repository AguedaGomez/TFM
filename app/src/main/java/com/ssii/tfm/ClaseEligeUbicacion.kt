package com.ssii.tfm

/**
 * Created by Ague on 16/04/2018.
 */
object ClaseEligeUbicacion {

    fun eligeUbicacion(lugar : String, anterior : Pair<String, Int>) : Pair<String, Int> {
        var conceptoElegido : Pair<String, Int>
        conceptoElegido = when (lugar) {
            "Universidad" -> EleccionAleatoria.elegirConcepto(Vocabulario.getUniversidad().filter { c -> c!= anterior })
            "Estacion" -> EleccionAleatoria.elegirConcepto(Vocabulario.getEstacion().filter { c -> c!= anterior })
            "Parque" ->  EleccionAleatoria.elegirConcepto(Vocabulario.getParque().filter { c -> c!= anterior })
            else -> EleccionAleatoria.elegirConcepto(Vocabulario.getAleatorio().filter { c -> c!= anterior })
        }
        return conceptoElegido
    }
}