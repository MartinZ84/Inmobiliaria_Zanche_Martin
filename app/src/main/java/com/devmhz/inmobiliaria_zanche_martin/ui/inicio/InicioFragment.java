package com.devmhz.inmobiliaria_zanche_martin.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.devmhz.inmobiliaria_zanche_martin.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class InicioFragment extends Fragment {

private   TextView tvHome;
private GoogleMap mapa;
private LatLng INMOBILIARIA = new LatLng(-33.3079039, -66.3358829);
private LatLng ULP = new LatLng(-33.150720, -66.306864);
private Button btCambiarMapa, btUbicacion;

    /*public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InicioViewModel homeViewModel =
                new ViewModelProvider(this).get(InicioViewModel.class);

        //setContentView(R.layout.activity_main);
       // SupportMapFragment smf = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.frMap);
        //SupportMapFragment smf= (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.frMap);
        SupportMapFragment smf= (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frMap);
        smf.getMapAsync(new MapaInmobiliaria());

        View root = inflater.inflate(R.layout.fragment_inicio, container, false);

        tvHome=root.findViewById(R.id.text_home);
        tvHome.setText("Este es el fragment inicio");



        return root;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.fragment_inicio, container, false);

        //Si usas getActivity estas suponiendo que la vista se buscara en el layout cargado por la Activity.
        //SupportMapFragment mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frMap);

        mapFragment.getMapAsync(this::onMapReady);

        return rootView;


    }


    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa=googleMap;
        CameraPosition camPos = new CameraPosition.Builder().target(INMOBILIARIA).zoom(18).bearing(0).tilt(0).build();
        CameraUpdate camUpdICT = CameraUpdateFactory.newCameraPosition(camPos);
        mapa.animateCamera(camUpdICT);

        mapa.addMarker(new MarkerOptions().position(INMOBILIARIA)).setTitle("Inmobiliaria MHZ");
        mapa.addMarker(new MarkerOptions().position(ULP)).setTitle("ULP");
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);



    }

   /* public  class MapaInmobiliaria implements OnMapReadyCallback {

        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            mapa=googleMap;
            CameraPosition camPos = new CameraPosition.Builder().target(INMOBILIARIA).zoom(20).bearing(45).tilt(0).build();
            CameraUpdate camUpdICT = CameraUpdateFactory.newCameraPosition(camPos);
            mapa.animateCamera(camUpdICT);

            mapa.addMarker(new MarkerOptions().position(INMOBILIARIA)).setTitle("Inmobiliaria MHZ");
            mapa.addMarker(new MarkerOptions().position(ULP)).setTitle("ULP");
            mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);



        }
    }*/



    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}