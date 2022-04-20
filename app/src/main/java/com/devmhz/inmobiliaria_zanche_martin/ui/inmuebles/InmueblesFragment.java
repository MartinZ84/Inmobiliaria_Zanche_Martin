package com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.devmhz.inmobiliaria_zanche_martin.R;


public class InmueblesFragment extends Fragment {
        private TextView tvInmuebles;


        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {
            InmueblesViewModel slideshowViewModel =
                    new ViewModelProvider(this).get(InmueblesViewModel.class);


            View root = inflater.inflate(R.layout.fragment_inmuebles, container, false);
            tvInmuebles= root.findViewById(R.id.text_slideshow);
            tvInmuebles.setText("Este es el fragment Inmuebles");

            return root;
        }

        @Override
        public void onDestroyView() {

            super.onDestroyView();
        }
    }

