package com.devmhz.inmobiliaria_zanche_martin.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.devmhz.inmobiliaria_zanche_martin.R;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inquilino;
import com.devmhz.inmobiliaria_zanche_martin.ui.contratos.DetalleContratoFragment;
import com.devmhz.inmobiliaria_zanche_martin.ui.contratos.DetalleContratoViewModel;

public class InquilinoFragment extends Fragment {

    private InquilinoViewModel mViewModel;
    private TextView tvId;
    private TextView tvNombre;
    private TextView tvApellido;
    private TextView tvDni;
    private TextView tvEmail;
    private TextView tvTelefono;
    private TextView tvGarante;
    private TextView tvTelGarante;
    private TextView tvLugarTrabajo;

    public static InquilinoFragment newInstance() {
        return new InquilinoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root= inflater.inflate(R.layout.inquilino_fragment, container, false);
        inicializar(root);
        return root;
    }

    private void inicializar(View view) {
        tvId = view.findViewById(R.id.tvId);
        tvNombre = view.findViewById(R.id.tvNombre);
        tvApellido = view.findViewById(R.id.tvApellido);
        tvDni = view.findViewById(R.id.tvDni);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTelefono = view.findViewById(R.id.tvTelefono);
        tvGarante=view.findViewById(R.id.tvGarante);
        tvTelGarante=view.findViewById(R.id.tvTelGarante);
        tvLugarTrabajo=view.findViewById(R.id.tvLugarTrabajo);
        mViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);


            mViewModel.getInquilino().observe(getActivity(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                tvId.setText(contrato.getInquilino().getId() + "");
                tvNombre.setText(contrato.getInquilino().getNombre());
                tvApellido.setText(contrato.getInquilino().getApellido());
                tvDni.setText(contrato.getInquilino().getDni());
                tvEmail.setText(contrato.getInquilino().getEmail());
                tvTelefono.setText(contrato.getInquilino().getTelefono());
                tvGarante.setText(contrato.getNombre_Garante()  + " " + contrato.getApellido_Garante());
                tvTelGarante.setText(contrato.getTelefono_Garante());
                tvLugarTrabajo.setText(contrato.getInquilino().getLugar_Trabajo());

            }
        });



        mViewModel.cargarInquilino(getArguments());
    }

}