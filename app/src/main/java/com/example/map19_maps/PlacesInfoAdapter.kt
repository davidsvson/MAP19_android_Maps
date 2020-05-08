package com.example.map19_maps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class PlacesInfoAdapter(val context : Context) : GoogleMap.InfoWindowAdapter {

    val layoutInflator : LayoutInflater

    init {
        layoutInflator = LayoutInflater.from(context)
    }

    override fun getInfoContents(p0: Marker?): View? {
        TODO("Not yet implemented")
        return null
    }

    override fun getInfoWindow(marker: Marker?): View {
        val infoWindow = layoutInflator.inflate(R.layout.info_window, null)

        val imageView = infoWindow.findViewById<ImageView>(R.id.image)
        val titleView = infoWindow.findViewById<TextView>(R.id.title)
        val snippetView = infoWindow.findViewById<TextView>(R.id.snippet)

        titleView.text = marker?.title
        snippetView.text = marker?.snippet
        imageView.setImageResource(marker?.tag as Int)

/*      om vi använder vårt alternativ med createplaces i stället i vår activitet
        titleView.text = (marker?.tag as PlaceInfo).name
        snippetView.text = (marker?.tag as PlaceInfo).info
        imageView.setImageResource((marker?.tag as PlaceInfo).image)
*/
        return infoWindow

    }


}