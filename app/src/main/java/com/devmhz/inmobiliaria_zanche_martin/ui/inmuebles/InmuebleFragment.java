package com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.devmhz.inmobiliaria_zanche_martin.LoginActivity;
import com.devmhz.inmobiliaria_zanche_martin.R;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;

public class InmuebleFragment extends Fragment {

    private InmuebleViewModel inmuebleViewModel;
    private TextView tvId;
    private TextView tvDireccion;
    private TextView tvTipo;
    private TextView tvUso;
    private TextView tvAmbientes;
    private TextView tvPrecio;
    private CheckBox cbEstado;
    private ImageView ivImagenInmueble;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inmueble_fragment, container, false);
        inicializar(root);
        inmuebleViewModel.getMensaje().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
        return root;
    }

    private void inicializar(View view) {
        tvId = view.findViewById(R.id.tvId);
        tvDireccion = view.findViewById(R.id.tvDireccion);
        tvTipo = view.findViewById(R.id.tvTipo);
        tvUso = view.findViewById(R.id.tvUso);
        tvAmbientes = view.findViewById(R.id.tvAmbientes);
        tvPrecio = view.findViewById(R.id.tvPrecio);
        cbEstado = view.findViewById(R.id.cbEstado);
        ivImagenInmueble = view.findViewById(R.id.ivImagenInmueble);
        inmuebleViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InmuebleViewModel.class);
        inmuebleViewModel.getInmueble().observe(getActivity(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                tvId.setText(inmueble.getId() + "");
                tvDireccion.setText(inmueble.getDireccion());
                tvTipo.setText(inmueble.getTipo());
                tvUso.setText(inmueble.getUso());
                tvAmbientes.setText(inmueble.getAmbientes() + "");
                tvPrecio.setText("$" + inmueble.getPrecio());
                cbEstado.setChecked(inmueble.getEstadoInmueble());
                cbEstado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        inmuebleViewModel.cambiarDisponibilidad(isChecked);
                        if (isChecked) {
                         Log.d("checkbox", String.valueOf(isChecked));

                        } else
                        Log.d("checkbox", String.valueOf(isChecked));
                    }
                });




                Glide.with(getContext())
                        .load(inmueble.getImagen())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(ivImagenInmueble);


            }
        });

        inmuebleViewModel.cargarInmueble(getArguments());
    }

}