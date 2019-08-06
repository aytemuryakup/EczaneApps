package com.example.eczaneapps;


import android.os.Bundle;
import android.widget.Toast;


import androidx.fragment.app.FragmentActivity;

import com.example.eczaneapps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class EczaneMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    String konum,adi,adres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczane_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        konum = getIntent().getStringExtra("EczaneKonum");

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        konum = getIntent().getStringExtra("EczaneKonum");
        adi = getIntent().getStringExtra("EczaneAdi");
        adres = getIntent().getStringExtra("EczaneAdres");
        String[] ayirma = konum.split(",");

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng eczanekonum = new LatLng(Double.parseDouble(ayirma[0]), Double.parseDouble(ayirma[1]));
        mMap.addMarker(new MarkerOptions().position(eczanekonum).title(adi).snippet(adres));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(eczanekonum,15));
    }
}
