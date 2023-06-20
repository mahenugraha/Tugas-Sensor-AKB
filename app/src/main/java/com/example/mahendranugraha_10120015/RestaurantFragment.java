package com.example.mahendranugraha_10120015;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mahendranugraha_10120015.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.Task;

// NIM : 10120015
// NAMA : MAHENDRA NUGRAHA
// KELAS : IF 1
public class RestaurantFragment extends Fragment {

    private SupportMapFragment mapFragment;
    private FusedLocationProviderClient client;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restauran, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        client = LocationServices.getFusedLocationProviderClient(getActivity());
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.my_map);

        getLocation();
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        Task<Location> task = client.getLastLocation();
        task.addOnSuccessListener(location -> {
            if(location != null){
                mapFragment.getMapAsync(new OnMapReadyCallback() {
                    @Override
                    public void onMapReady(@NonNull GoogleMap googleMap) {
                        LatLng lokasi1 = new LatLng(-6.889168483889433, 107.62013400922663);
                        MarkerOptions options1 = new MarkerOptions().position(lokasi1).title("Warung Nasi sederhana bu ai");
                        googleMap.addMarker(options1);
                        LatLng lokasi2 = new LatLng(-6.889669383222151, 107.6206704846888);
                        MarkerOptions options2 = new MarkerOptions().position(lokasi2).title("Ayam Bakar 76");
                        googleMap.addMarker(options2);
                        LatLng lokasi3 = new LatLng(-6.890024450785839, 107.6199253798826);
                        MarkerOptions options3 = new MarkerOptions().position(lokasi3).title("Warung nasi mang dry");
                        googleMap.addMarker(options3);
                        LatLng lokasi4 = new LatLng(-6.889842690043808, 107.62115373838132);
                        MarkerOptions options4 = new MarkerOptions().position(lokasi4).title("Warung kopi garsel");
                        googleMap.addMarker(options4);
                        LatLng lokasi5 = new LatLng(-6.889463568216098, 107.62125828392358);
                        MarkerOptions options5 = new MarkerOptions().position(lokasi5).title("Sate Suki Seafood");
                        googleMap.addMarker(options5);
                        googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(lokasi2,16));
                    }
                });
            }
        });
    }
}