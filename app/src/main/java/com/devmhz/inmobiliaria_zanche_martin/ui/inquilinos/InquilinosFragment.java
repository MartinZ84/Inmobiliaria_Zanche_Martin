package com.devmhz.inmobiliaria_zanche_martin.ui.inquilinos;

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
import com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles.InmueblesViewModel;

public class InquilinosFragment extends Fragment {
    private TextView tvInquilinos;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InquilinosViewModel inquilinosViewModel =
                new ViewModelProvider(this).get(InquilinosViewModel.class);


        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);
        tvInquilinos= root.findViewById(R.id.tvInquilino);
        tvInquilinos.setText("Este es el fragment de inquilinos");

        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
    }
}