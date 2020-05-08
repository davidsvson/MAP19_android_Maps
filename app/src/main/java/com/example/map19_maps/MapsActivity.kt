package com.example.map19_maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {


    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnInfoWindowClickListener(this)

        createMarkers()
        //createPlaces()

       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sthlm))
        val adapter = PlacesInfoAdapter(this)
        mMap.setInfoWindowAdapter(adapter)
    }

    override fun onInfoWindowClick(marker: Marker?) {
        if (marker != null) {
            Toast.makeText(this, marker.tag.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    fun createMarkers() {
        val sthlm = LatLng(59.3, 18.0)
        var marker = mMap.addMarker(MarkerOptions()
            .position(sthlm)
            .title("Title: Stockholm")
            .snippet("Vackert här!"))

        //marker.showInfoWindow()


        marker.tag = R.drawable.ic_healing_black_24dp

        marker = mMap.addMarker(MarkerOptions()
            .position(LatLng(60.0, 20.0))
            .title("Platys2")
            .snippet("Vackert här!"))
        //marker.showInfoWindow()
       marker.tag = R.drawable.ic_time_to_leave_black_24dp

        marker = mMap.addMarker(MarkerOptions()
            .position(LatLng(61.0, 20.0))
            .title("Plats3")
            .snippet("Vackert här!"))
        marker.tag = R.drawable.ic_toys_black_24dp

    }
/*
    fun createPlaces() {
        val p1 = PlaceInfo("p1", "vackert", LatLng(30.0, 40.0), R.drawable.ic_healing_black_24dp)
        val p2 = PlaceInfo("p2", "vackert", LatLng(32.0, 42.0), R.drawable.ic_toys_black_24dp)

        var mark = mMap.addMarker(MarkerOptions().position(p1.position))
        mark.tag = p1
        mark = mMap.addMarker(MarkerOptions().position(p2.position))
        mark.tag = p2
    }
*/
}

//class PlaceInfo(val name: String, val info: String, val position: LatLng, val image: Int)
