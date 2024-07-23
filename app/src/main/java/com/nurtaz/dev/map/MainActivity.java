package com.nurtaz.dev.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener
, GoogleMap.OnInfoWindowClickListener {
 private GoogleMap mMap;
 private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        LatLng sydney = new LatLng(1.37,103 );
        LatLng m2 = new LatLng(25,45 );
        LatLng m3 = new LatLng(30,50 );
        LatLng m4 = new LatLng(35,55);
        LatLng m5 = new LatLng(15,5);
        LatLng m6 = new LatLng(145,175);
        LatLng m7 = new LatLng(245,275);
        LatLng m8 = new LatLng(445,475);
        LatLng m9 = new LatLng(1,1);
        LatLng m10 = new LatLng(2,4);
        LatLng m11= new LatLng(3,1);
        LatLng m12= new LatLng(1,1);
        LatLng m13= new LatLng(20,35);
        LatLng m14= new LatLng(40,75);
        LatLng m15= new LatLng(80,87);
        LatLng m16= new LatLng(45.5,57);
        LatLng m17= new LatLng(67,105);
        marker = mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("marker 1"));
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);

//        mMap.addMarker(new MarkerOptions()
//                .position(sydney)
//                .draggable(true) //can move marker
//                .snippet("Subscribe my channel") // below title
//                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.gril))
//                .title("Marker in Singapore"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //polyline
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(m5)
                .add(m2)
                .add(m3)
                .add(m4)
                .color(android.R.color.holo_orange_light)
                .width(10);

        Polyline polyline = mMap.addPolyline(polylineOptions);
        polyline.isClickable();

        ArrayList<LatLng> arrayList = new ArrayList();
        arrayList.add(m9);
        arrayList.add(m10);
        arrayList.add(m11);
        arrayList.add(m12);
        //polygons
        PolygonOptions polygonOptions =new PolygonOptions()
                .add(m6,m7,m8)
                .addHole(arrayList)
                .fillColor(Color.GREEN)
                .strokeColor(Color.YELLOW)

                ;

        //get back the mutable polygon
        Polygon polygon = mMap.addPolygon(polygonOptions);

        //circle
        CircleOptions circleOptions = new CircleOptions()
                .center(sydney)
                .radius(10000) ;//in meters


        //get back te mutable
        Circle circle = mMap.addCircle(circleOptions);
        circle.setStrokeColor(Color.BLUE);

        //List

        List<PatternItem> patternItems = Arrays.asList(
                new Dot(),
                new Gap(10),
                new Dash(30)
        );

        PolylineOptions polylineOptionsStroke = new PolylineOptions()
                .add(m13,m14,m15,m16,m17);
        Polyline polyline1 = mMap.addPolyline(polylineOptionsStroke);

        polyline1.setPattern(patternItems);
    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
       Toast.makeText(this,"my  position"+marker.getPosition(), Toast.LENGTH_SHORT ).show();

        return false;
    }

    @Override
    public void onInfoWindowClick(@NonNull Marker marker) {

    }

}