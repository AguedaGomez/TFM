package com.ssii.tfm

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import com.ubikgs.androidsensors.AndroidSensors
import com.ubikgs.androidsensors.SensorType
import com.ubikgs.androidsensors.gatherers.gps.LocationGatherer
import com.ubikgs.androidsensors.records.gps.LocationRecord
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val permissionRequestCode = 0
    private lateinit var locationGatherer: LocationGatherer
    private var locationSuscription : Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main

        val androidSensors = AndroidSensors
                .builder()
                .build(this)

        this.locationGatherer = androidSensors.sensorGathererBy(SensorType.LOCATION) as LocationGatherer
    }

    override fun onPause() {
        super.onPause()
        // Apagar la ubicación cuando la aplicación esté en segundo plano
        this.locationSuscription?.dispose()
    }

    override fun onStart() {
        super.onStart()
        startListeningUserLocation()
    }

    private fun startListeningUserLocation() {
        // Mirar si tienes permiso del usuario
        if (!locationGatherer.hasPermissionGranted()) {
            ActivityCompat.requestPermissions(this, arrayOf(locationGatherer.neededPermission), permissionRequestCode)
            return
        }

        // Mirar si está disponible
        if (!locationGatherer.isReady) {
            locationGatherer.askForEnabling()
            return
        }

        locationSuscription = locationGatherer
                .recordStream()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .take(1)
                .subscribe({
                    val locationRecord = it as LocationRecord
                    latitud.text = locationRecord.latitude.toString()
                    longitud.text = locationRecord.longitude.toString()
                    //Log.d("Localizacion", locationRecord.toString())
                })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == this.permissionRequestCode) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startListeningUserLocation()
            }
        }
    }

    fun eligeUbicacion(btnText : String) {
        val bundle = intent.extras
        val modo = bundle.getString("modo")
        val intent = Intent(this@MainActivity, AprendizajeActivity::class.java)
        intent.putExtra("ubicacion", btnText)
        intent.putExtra("modo", modo)
        println(btnText)
        startActivity(intent)
    }

}
