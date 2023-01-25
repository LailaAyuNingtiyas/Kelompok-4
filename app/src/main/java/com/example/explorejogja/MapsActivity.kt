package com.example.explorejogja

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.example.explorejogja.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : FragmentActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : ActivityMapsBinding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        val btnbelitiket = findViewById<Button>(R.id.belitiket)
        btnbelitiket.setOnClickListener(View.OnClickListener {
            val open = Intent(this@MapsActivity, TransaksiActivity::class.java)
            startActivity(open)
        })
        val btnkembalikelist : ImageView = findViewById(R.id.kembalikelist)
        btnkembalikelist.setOnClickListener(View.OnClickListener {
            val open = Intent(this@MapsActivity, ListActivity::class.java)
            startActivity(open)
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val mMap : GoogleMap = googleMap

        // Membuat marker berdasarkan Latitude dan Longtitude
        val LinSe = LatLng(-7.9158, 110.4366)
        mMap.addMarker(MarkerOptions().position(LinSe).title("Bukit Lintang Sewu"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(LinSe))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f))
    }
}