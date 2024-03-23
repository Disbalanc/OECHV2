package com.example.oech.Profile.ui.track

import android.content.pm.PackageManager

import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.views.MapView

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.oech.R
import com.example.oech.databinding.FragmentTrackBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

    class TrackFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    private var _binding: FragmentTrackBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Настройка OsmDroid
        val osmConfig = Configuration.getInstance()
        osmConfig.load(context, context?.getSharedPreferences("osm", 0))

        // Создание MapView
        val rootView = inflater.inflate(R.layout.fragment_track, container, false)
        val map = rootView.findViewById(R.id.map) as MapView
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setMultiTouchControls(true)

        return rootView
    }

        override fun onResume() {
            super.onResume()
            // Необходимые обновления при восстановлении фрагмента
            val osmConfig = Configuration.getInstance()
            osmConfig.load(context, context?.getSharedPreferences("osm", 0))
        }

        override fun onPause() {
            super.onPause()
            // Необходимые обновления при приостановке фрагмента
            val osmConfig = Configuration.getInstance()
            osmConfig.save(context, context?.getSharedPreferences("osm", 0))
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}