package com.ssii.tfm

/**
 * Created by Ague on 15/04/2018.
 */
object EleccionAleatoria {
    fun elegirConcepto(vocabulario: List<Pair<String, Int>>) : Pair<String, Int>{
        var rand : Int = ((Math.random() * vocabulario.size).toInt())
        val concepto = vocabulario.elementAt(rand)
        return concepto
    }
}