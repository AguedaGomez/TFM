package com.ssii.tfm

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException


object Adaptador {
    val client = OkHttpClient()

    @Throws(IOException::class)
    fun run(url: String): String {
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).execute().use { response -> return response.body()!!.string() }
    }

}