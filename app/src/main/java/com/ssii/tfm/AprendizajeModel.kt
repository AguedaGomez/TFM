package com.ssii.tfm

object AprendizajeModel {
    val numeroConceptosEnseniados : Int = 9
    var conceptosEnseniados : MutableList<Pair<String, Int>> = mutableListOf()
    var conceptosConocidos : MutableList<String> = mutableListOf()
    var conceptoAnterior : Pair<String, Int> = ("" to -1)

    fun eligeUbicacion (lugar : String) : Pair<String, Int> {
        println("concepto anterior: " + conceptoAnterior)
        val concepto = ClaseEligeUbicacion.eligeUbicacion(lugar, conceptoAnterior)
        //if (!conceptosEnseniados.contains(concepto))conceptosEnseniados.add(concepto)
        conceptoAnterior = concepto
        return concepto
    }

    fun guardarConceptoEnseniado (concepto : Pair <String, Int>) {
        if (!conceptosEnseniados.contains(concepto))conceptosEnseniados.add(concepto)
    }

    fun guardarPalabraConocida (palabra : String) {
        conceptosConocidos.add(palabra)
        println("conceptos conocidos: " + conceptosConocidos)
    }

    fun comprobarNumeroConceptosEnseniados() : Boolean {
        var evaluar : Boolean = false
        if (conceptosEnseniados.count() == numeroConceptosEnseniados)  evaluar = true
        return evaluar
    }



}