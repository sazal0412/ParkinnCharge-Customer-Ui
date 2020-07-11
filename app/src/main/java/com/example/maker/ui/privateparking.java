package com.example.maker.ui;


import android.content.IntentSender;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maker.R;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 */
public class privateparking extends Fragment implements OnMapReadyCallback {


    FusedLocationProviderClient fusedLocationClient;
    GoogleMap map;
    LatLng usercurLoc;
    public static String  location;


    SupportMapFragment mapFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate( R.layout.fragment_privateparking, container, false );

        CardView cardView = view.findViewById(R.id.card12);
        cardView.setBackgroundResource(R.drawable.customcard);

        return view;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        MapView mMapView = (MapView) view.findViewById(R.id.map1);
        if (
                mMapView != null)
        {

            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        try {
            boolean isSuccess = googleMap.setMapStyle( MapStyleOptions.loadRawResourceStyle( getContext(), R.raw.map )
            );
            if (!isSuccess)
                Log.e( "ERROR", "Map style load failed !" );
        } catch (Resources.NotFoundException ex) {
            ex.printStackTrace();
        }
       // FloatingActionButton FAB =(FloatingActionButton) getView().findViewById(R.id.floatingActionButton);
      //  FAB.setOnClickListener( new View.OnClickListener() {
         //   @Override
           // public void onClick(View v) {

             //   map.moveCamera( CameraUpdateFactory.newLatLngZoom( usercurLoc, 15 ) );
          //  }
       // } );

        map = googleMap;
       // map.setMyLocationEnabled( true );
        map.getUiSettings().setMapToolbarEnabled( true );
        map.getUiSettings().setMyLocationButtonEnabled( true );
        map.getUiSettings().setCompassEnabled( false );


        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval( 10000 );
        locationRequest.setFastestInterval( 5000 );
        locationRequest.setPriority( LocationRequest.PRIORITY_HIGH_ACCURACY );
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest( locationRequest );
        SettingsClient client = LocationServices.getSettingsClient( getActivity() );
        Task<LocationSettingsResponse> task = client.checkLocationSettings( builder.build() );
        task.addOnSuccessListener( getActivity(), new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                // All location settings are satisfied. The client can initialize
                // location requests here.
                // ...
                fusedLocationClient = LocationServices.getFusedLocationProviderClient( getActivity() );
                fusedLocationClient.getLastLocation()
                        .addOnSuccessListener( getActivity(), new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location ) {
                                // Got last known location. In some rare situations this can be null.
                                if (location != null) {
                                    // Logic to handle location object
                                    Log.d( "Location fetched", "" );
                                    usercurLoc = new LatLng( location.getLatitude(), location.getLongitude() );
                                    map.moveCamera( CameraUpdateFactory.newLatLngZoom( usercurLoc, 15 ) );
                                    map.addMarker(new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("You're here!"));
                                }
                            }
                        } );
            }
        } );

        task.addOnFailureListener( getActivity(), new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException) {
                    // Location settings are not satisfied, but this can be fixed
                    // by showing the user a dialog.
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        ResolvableApiException resolvable = (ResolvableApiException) e;
                        resolvable.startResolutionForResult( getActivity(),
                                100 );
                    } catch (IntentSender.SendIntentException sendEx) {
                        // Ignore the error.
                    }
                }
            }
        } );


        //  map.setOnMarkerClickListener( new GoogleMap.OnMarkerClickListener() {
        //  @Override
        //  public boolean onMarkerClick(Marker marker) {
        //reached_button.setVisibility(View.VISIBLE);
        //  location = marker.getTitle();
        // map.setPadding( 10, 20, 150, 250 );
        //  return false;
    }
    //  } );


}