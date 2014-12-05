package com.cookiebots.applindl;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;

import com.cookiebots.metier.Lieu;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by Alexandre on 04/12/2014.
 */

public class MapActivity extends Activity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.map_activity);

            // Get a handle to the Map Fragment
            GoogleMap map = ((MapFragment) getFragmentManager()
                    .findFragmentById(R.id.map)).getMap();

            LatLng syrie = new LatLng(34.923081, 39.002507);

            map.setMyLocationEnabled(true);
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(syrie, 13));

        }

    private MarkerOptions makeMarker(double Lat, double Lng, String titre, String snip){
        LatLng pos = new LatLng(Lat, Lng);
        MarkerOptions marker = new MarkerOptions().title(titre).snippet(snip).position(pos);
        return marker;
    }

    private CircleOptions makeCircle(LatLng center, float width){
        CircleOptions circle = new CircleOptions();
        circle.center(center);
        circle.strokeWidth(width);
        return circle;
    }


}
