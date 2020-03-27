package com.example.observer;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.text.DecimalFormat;

import static java.lang.Math.atan2;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class MapsActivity extends AppCompatActivity
        implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback, GoogleMap.OnMarkerDragListener, GoogleMap.OnMapLongClickListener{

    private GoogleMap mMap;
    Location ownloc,enloc;
    LatLng en,own;
    double enLat;
    double enLong;
    String GROwn,GREn;
    String OEast,ONorth,EEast,ENorth;
    String OTbg;
    float bg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.current_place_menu, menu);
        return true;
    }

    /**
     * Handles a click on the menu option to get a place.
     * @param item The menu item to handle.
     * @return Boolean.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.option_get_place) {
            String[] data={OEast,ONorth,EEast,ENorth, String.valueOf(bg)};
            Bundle bundle = new Bundle();
            bundle.putString("et1", data[0]);
            bundle.putString("et2",data[1]);
            bundle.putString("et3", data[2]);
            bundle.putString("et4",data[3]);
            bundle.putString("et5", data[4]);
            Intent intent = new Intent(MapsActivity.this, TargetDataUI.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.get_dis) {
            double dis=CalculationByDistance(own,en);
            Toast.makeText(this, "Distance in kilometer:\n" + dis , Toast.LENGTH_LONG).show();
        }

        if (item.getItemId() == R.id.get_bg) {
            bg=calculate_bg();
            Toast.makeText(this, "Bearing :\n" + bg, Toast.LENGTH_LONG).show();
        }
        return true;
    }


    private float calculate_bg() {
            double Phi1 = Math.toRadians(ownloc.getLatitude());
            double Phi2 = Math.toRadians(en.latitude);
            double DeltaLambda = Math.toRadians(en.longitude- ownloc.getLongitude());
            double Theta = atan2((sin(DeltaLambda)*cos(Phi2)),
                    (cos(Phi1)*sin(Phi2) - sin(Phi1)*cos(Phi2)*cos(DeltaLambda)));
            return (float)Math.toDegrees(Theta);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        // TODO: Before enabling the My Location layer, you must request
        mMap.setMyLocationEnabled(true);
        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapLongClickListener(this);

    }


        @Override
        public void onMyLocationClick (@NonNull Location location){
            mMap.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("It's Me!"));
            ownloc=location;
            own=new LatLng(location.getLatitude(),location.getLongitude());
            GeoCoordinateConverter mgrs=new GeoCoordinateConverter();
            GROwn=mgrs.latLon2MGRS(own.latitude,own.longitude);
            Toast.makeText(this, "Own location:\n" + GROwn, Toast.LENGTH_LONG).show();
            OEast=GROwn.substring(6,12);
            ONorth=GROwn.substring(12);
        }

        @Override
        public boolean onMyLocationButtonClick () {
            Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
            // Return false so that we don't consume the event and the default behavior still occurs
            // (the camera animates to the user's current position).
            return false;
        }

    @Override
    public void onMarkerDragStart(Marker marker) {
        Toast.makeText(MapsActivity.this, "onMarkerDragStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        Toast.makeText(MapsActivity.this, "onMarkerDrag", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        enLat = marker.getPosition().latitude;
        enLong = marker.getPosition().longitude;
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        en=latLng;
        mMap.addMarker(new MarkerOptions().position(latLng).draggable(true));
        GeoCoordinateConverter mgrs=new GeoCoordinateConverter();
        GREn=mgrs.latLon2MGRS(en.latitude,en.longitude);
        Toast.makeText(this, "Enemy location:\n" + GREn, Toast.LENGTH_LONG).show();
        mMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude)).title("It's En!"));
        EEast=GREn.substring(6,12);
        ENorth=GREn.substring(12);
    }

    public double CalculationByDistance(LatLng own, LatLng en) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = own.latitude;
        double lat2 =en.latitude;
        double lon1 = own.longitude;
        double lon2 = en.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return Radius * c;
    }


}
