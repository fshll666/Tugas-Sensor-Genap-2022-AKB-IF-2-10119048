/**
 * Mochammad Faishal
 * 10119048
 * IF2
 */

package com.example.tugas_sensor_2022_akb_if2_10119048;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tugas_sensor_2022_akb_if2_10119048.R;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
public class CafeMap extends Fragment{
    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng lokasi1 = new LatLng(-6.982114869468791, 107.43413231450695);
            googleMap.addMarker(new MarkerOptions().position(lokasi1).title("Saung Bonsai Cililin").snippet("Cafe resto").icon(BitmapDescriptorFactory.fromResource(R.drawable.maps)));
            LatLng lokasi2 = new LatLng(-6.97832371314945, 107.43129990192233);
            googleMap.addMarker(new MarkerOptions().position(lokasi2).title("Kedai Baso Hj acan").snippet("Warung baso").icon(BitmapDescriptorFactory.fromResource(R.drawable.maps)));
            LatLng lokasi3 = new LatLng(-6.9511010797320685, 107.45764591181157);
            googleMap.addMarker(new MarkerOptions().position(lokasi3).title("Jawara Coffe").snippet("Angkringan").icon(BitmapDescriptorFactory.fromResource(R.drawable.maps)));
            LatLng lokasi4 = new LatLng(-6.953410399368878, 107.45088855743391);
            googleMap.addMarker(new MarkerOptions().position(lokasi4).title("Cafe Resto 234").snippet("Cafe").icon(BitmapDescriptorFactory.fromResource(R.drawable.maps)));
            LatLng lokasi5 = new LatLng(-6.954429675716189, 107.44900893686159);
            googleMap.addMarker(new MarkerOptions().position(lokasi5).title("Two hands Coffe").snippet("Tempat Kopi").icon(BitmapDescriptorFactory.fromResource(R.drawable.maps)));

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(lokasi4));
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi4,18));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mapcafe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}
