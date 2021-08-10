package be.ehb.myrecipe.fragments.map;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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

    public void mapStartup(){
        LatLng Brussels = new LatLng(50.85045, 4.34878);
        MyGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Brussels, 11));
    }


    public void addMarkers(){
        LatLng ColruytSchaarbeek_pos = new LatLng(50.8670705,4.3693105);
        LatLng ColruytLaken_pos = new LatLng(50.8721224,4.3388136);
        LatLng ColruytUkkel_pos = new LatLng(50.7966789,4.3207686);
        LatLng CarrefourElsene_pos = new LatLng(50.8167648,4.3718187);
        LatLng CarrefourKoekelberg_pos = new LatLng(50.8720464,4.290127);
        LatLng AldiWoluweSaintLambert_pos = new LatLng(50.8428423,4.4058428);
        LatLng AldiSchaarbeek_pos = new LatLng(50.8604597,4.3844432);
        LatLng LidlAnderlecht_pos = new LatLng(50.8312817,4.3096019);
        LatLng LidlSchaarbeek_pos = new LatLng(50.852256,4.3413841);

        Marker ColruytSchaarbeek = MyGoogleMap.addMarker(new MarkerOptions().position(ColruytSchaarbeek_pos).title("Colruyt Schaarbeek"));
        Marker ColruytLaken = MyGoogleMap.addMarker(new MarkerOptions().position(ColruytLaken_pos).title("Colruyt Laken"));
        Marker ColruytUkkel = MyGoogleMap.addMarker(new MarkerOptions().position(ColruytUkkel_pos).title("Colruyt Ukkel"));
        Marker CarrefourElsene = MyGoogleMap.addMarker(new MarkerOptions().position(CarrefourElsene_pos).title("Carrefour Elsene"));
        Marker CarrefourKoekelberg = MyGoogleMap.addMarker(new MarkerOptions().position(CarrefourKoekelberg_pos).title("Carrefour Koekelberg"));
        Marker AldiWoluweSaintLambert = MyGoogleMap.addMarker(new MarkerOptions().position(AldiWoluweSaintLambert_pos).title("Aldi Woluwe-Saint-Lambert"));
        Marker AldiSchaarbeek = MyGoogleMap.addMarker(new MarkerOptions().position(AldiSchaarbeek_pos).title("Aldi Schaarbeek"));
        Marker LidlAnderlecht = MyGoogleMap.addMarker(new MarkerOptions().position(LidlAnderlecht_pos).title("Lidl Anderlecht"));
        Marker LidlSchaarbeek = MyGoogleMap.addMarker(new MarkerOptions().position(LidlSchaarbeek_pos).title("Lidl Schaarbeek"));


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        MyGoogleMap = googleMap;
        mapStartup();
        addMarkers();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        MyMapView.onLowMemory();
    }
}