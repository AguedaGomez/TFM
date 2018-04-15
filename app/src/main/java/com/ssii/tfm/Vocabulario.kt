package com.ssii.tfm

/**
 * Created by Ague on 15/04/2018.
 */
object Vocabulario {

    fun getUniversidad () : List<Pair<String, Int>> {
       val listaVocabularioUniversidad : List<Pair<String, Int>> = listOf("classroom" to R.drawable.classroom, "campus" to R.drawable.campus, "commencement" to R.drawable.commencement)
        return listaVocabularioUniversidad
    }

    fun getEstacion () : List<Pair<String, Int>> {
        val listaVocabularioEstacion : List<Pair<String, Int>> = listOf("luggage" to R.drawable.luggage, "platform" to R.drawable.platform, "station" to R.drawable.station, "train" to R.drawable.train)
        return listaVocabularioEstacion
    }

    fun getParque () : List<Pair<String, Int>> {
        val listaVocabularioParque : List<Pair<String, Int>> = listOf("grass" to R.drawable.grass, "park" to R.drawable.park, "pigeon" to R.drawable.pigeon, "pound" to R.drawable.pound, "tree" to R.drawable.tree)
        return listaVocabularioParque
    }

    fun getAleatorio () : List<Pair<String, Int>> {
        val listaVocabularioAleatorio : List<Pair<String, Int>> = getUniversidad() + getEstacion() + getParque()
        return listaVocabularioAleatorio
    }
}