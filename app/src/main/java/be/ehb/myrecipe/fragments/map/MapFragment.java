package be.ehb.myrecipe.fragments.map;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;

import be.ehb.myrecipe.R;

public class MapFragment extends Fragment implements OnMapReadyCallback {

   private MapView MyMapView;
   private GoogleMap MyGoogleMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_map, container, false);
        MyMapView = rootView.findViewById(R.id.mapView);
        MyMapView.onCreate(savedInstanceState);
        MyMapView.getMapAsync(this);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        MyMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        MyMapView.onPause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MyMapView.onDestroy();
    }

    private void mapStartup(){
        LatLng Brussels = new LatLng(50.85045, 4.34878);
        MyGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Brussels, 10));
    }


    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        MyGoogleMap = googleMap;
        mapStartup();
    }



}