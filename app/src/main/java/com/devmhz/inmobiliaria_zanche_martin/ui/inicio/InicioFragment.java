package com.devmhz.inmobiliaria_zanche_martin.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.devmhz.inmobiliaria_zanche_martin.R;


public class InicioFragment extends Fragment {

private   TextView tvHome;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InicioViewModel homeViewModel =
                new ViewModelProvider(this).get(InicioViewModel.class);



        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
        tvHome=root.findViewById(R.id.text_home);
        tvHome.setText("Este es el fragment inicio");



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}