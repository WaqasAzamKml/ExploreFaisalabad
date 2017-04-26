package com.explorefaisalabad;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;



public class SingleLocation extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    TextView tvLocationTitle, tvAddress, tvContact;
    String location_parent, location_child;
    ImageView imgLocLogo;
    LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_location);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle bundle = getIntent().getExtras();

        tvLocationTitle = (TextView) findViewById(R.id.tvLocationTitle);
        tvContact = (TextView) findViewById(R.id.tvContact);
        tvAddress = (TextView) findViewById(R.id.tvLocAddress);
        imgLocLogo = (ImageView) findViewById(R.id.imgLocLogo);

        if(bundle!=null){
            tvLocationTitle.setText(bundle.getString("location_name"));
            tvAddress.setText(bundle.getString("location_address"));
            tvContact.setText(bundle.getString("location_contact"));
            location_parent = bundle.getString("location_parent");
            location_child = bundle.getString("location_child");
            if(location_parent.equals("Banks") && location_child.equals("MCB")){
                imgLocLogo.setImageResource(R.drawable.bank_mcb);
                Double latitude = bundle.getDouble("latitude");
                Double longitude = bundle.getDouble("longitude");
                latLng = new LatLng(latitude,longitude);
            }
            else if(location_parent.equals("Banks") && location_child.equals("UBL")){
                imgLocLogo.setImageResource(R.drawable.bank_ubl);
            }
            else if(location_parent.equals("Insurance Companies") && location_child.equals("0")){
                imgLocLogo.setImageResource(R.drawable.ins_igi);
            }
            else if(location_parent.equals("Insurance Companies") && location_child.equals("1")){
                imgLocLogo.
                        setImageResource(R.drawable.ins_efu);
            }
            else if(location_parent.equals("Courier & Logistics") && location_child.equals("0")) {
                imgLocLogo.setImageResource(R.drawable.cnl_tcs);
            }
            else if(location_parent.equals("Schools") && location_child.equals("0")) {
                imgLocLogo.setImageResource(R.drawable.school_dps);
            }
            else if(location_parent.equals("Schools") && location_child.equals("1")) {
                imgLocLogo.setImageResource(R.drawable.school_dmc);
            }
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if(latLng != null){
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,14.0f));
        }
        else {
            mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
        }

    }
}
