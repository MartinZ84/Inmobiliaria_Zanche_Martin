package com.devmhz.inmobiliaria_zanche_martin.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.devmhz.inmobiliaria_zanche_martin.R;

import com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles.InmueblesViewModel;

public class PerfilFragment extends Fragment {
    private TextView tvPerfil;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PerfilViewModel perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);


        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        tvPerfil= root.findViewById(R.id.tvPerfil);
        tvPerfil.setText("Este es el fragment perfil");

        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }
}