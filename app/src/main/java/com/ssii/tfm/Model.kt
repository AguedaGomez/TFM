package com.ssii.tfm

object Model {

    fun eligeUbicacion(lugar : String) : Pair<String, Int> {
        var conceptoElegido : Pair<String, Int>
        println("en eligeUbicacion del modelo")
        conceptoElegido = when (lugar) {
            "Universidad" -> elegirConcepto(Vocabulario.getUniversidad())
            "Estacion" -> elegirConcepto(Vocabulario.getEstacion())
            "Parque" ->  elegirConcepto(Vocabulario.getParque())
            else -> elegirConcepto(Vocabulario.getAleatorio())
        }
        return conceptoElegido
    }

    fun elegirConcepto(vocabulario: List<Pair<String, Int>>) : Pair<String, Int>{
        var rand : Int = ((Math.random() * vocabulario.size).toInt())
        val concepto = vocabulario.elementAt(rand)
         return concepto
    }
}