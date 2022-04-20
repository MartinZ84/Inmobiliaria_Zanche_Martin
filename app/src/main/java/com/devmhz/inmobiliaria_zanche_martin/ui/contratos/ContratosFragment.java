package com.devmhz.inmobiliaria_zanche_martin.ui.contratos;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devmhz.inmobiliaria_zanche_martin.R;
import com.devmhz.inmobiliaria_zanche_martin.ui.inicio.InicioViewModel;

public class ContratosFragment extends Fragment {

    private TextView tvContrato;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ContratosViewModel contratosViewModel =
                new ViewModelProvider(this).get(ContratosViewModel.class);



        View root = inflater.inflate(R.layout.fragment_contratos, container, false);
        tvContrato=root.findViewById(R.id.tvContrato);
        tvContrato.setText("Este es el fragment contratos");



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}