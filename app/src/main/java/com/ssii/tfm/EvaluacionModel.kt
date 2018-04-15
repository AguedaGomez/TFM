package com.ssii.tfm

object EvaluacionModel {

    fun elegirConceptoCorrecto (lugar : String): Pair<String, Int> {
       return AprendizajeModel.eligeUbicacion(lugar)
    }

    fun elegirConceptoErroneo1 (correcto : Pair<String, Int>) : Pair<String, Int> {
        return EleccionAleatoria.elegirConcepto(AprendizajeModel.conceptosEnseniados.filter { c -> c!=correcto })
    }

    fun elegirConceptoErroneo2 (correcto: Pair<String, Int>, erroneo1 : Pair<String, Int>) : Pair<String, Int> {
        return EleccionAleatoria.elegirConcepto(AprendizajeModel.conceptosEnseniados.filter { c -> c!= correcto || c!= erroneo1 })
    }
}