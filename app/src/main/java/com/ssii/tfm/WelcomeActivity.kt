package com.ssii.tfm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        Nolocalizacion.setOnClickListener{eligeModo("Nolocalizacion")}
        Localizacion.setOnClickListener{eligeModo("Localizacion")}
    }

    fun eligeModo (opcionElegida : String) {

       var intent = if (opcionElegida=="Localizacion") {
            Intent(this, MainActivity::class.java)
        } else {
            Intent(this, AprendizajeActivity::class.java)
        }
        intent.putExtra("modo", opcionElegida)
        startActivity(intent)
    }
}
