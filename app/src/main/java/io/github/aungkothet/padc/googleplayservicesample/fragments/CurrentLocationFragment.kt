package io.github.aungkothet.padc.googleplayservicesample.fragments


import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import io.github.aungkothet.padc.googleplayservicesample.R
import io.github.aungkothet.padc.googleplayservicesample.utils.locationPermissionsAreGranted

/**
 * A simple [Fragment] subclass.
 *
 */
class CurrentLocationFragment : Fragment() {

    companion object {
        const val TAG = "CurrentLocationFragment"
        fun newInstance(): Fragment {
            return CurrentLocationFragment()
        }
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_current_location, container, false)
        val tvLocation = view.findViewById<TextView>(R.id.tvMyLocation)
        val btn = view.findViewById<Button>(R.id.button)

        if (locationPermissionsAreGranted(context!!)) {
            setCurrentLocation(tvLocation)
        }

        btn.setOnClickListener { setCurrentLocation(tvLocation) }

        return view
    }


    @SuppressLint("MissingPermission", "SetTextI18n")
    private fun setCurrentLocation(tvLocation: TextView) {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context!!)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->

                Log.e("location", location.toString())
                tvLocation.text = "MyLocationIs: Lat=> ${location!!.latitude} & Lng=> ${location!!.longitude}"
            }
            .addOnFailureListener {
                Log.e("location", it.localizedMessage)
                tvLocation.text = it.localizedMessage
            }
    }


}
