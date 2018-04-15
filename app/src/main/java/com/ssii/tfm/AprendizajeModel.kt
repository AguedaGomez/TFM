package com.ssii.tfm

object AprendizajeModel {

    var conceptosEnseniados : MutableList<Pair<String, Int>> = mutableListOf()

    fun eligeUbicacion (lugar : String) : Pair<String, Int> {
       val concepto = ClaseEligeUbicacion.eligeUbicacion(lugar)
        conceptosEnseniados.add(concepto)
        return concepto
    }



}