package io.github.aungkothet.padc.googleplayservicesample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import io.github.aungkothet.padc.googleplayservicesample.R

class PlaceApiActivity : AppCompatActivity() {


    private  lateinit var placeClient : PlacesClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_api)

        val apiKey = "YOUR_GOOGLE_PLACE_KEY"

        if(!Places.isInitialized())
        {
            Places.initialize(applicationContext,apiKey)
        }

        placeClient = Places.createClient(this)
    }
}
