package com.devmhz.inmobiliaria_zanche_martin.ui.perfil;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.devmhz.inmobiliaria_zanche_martin.LoginActivity;
import com.devmhz.inmobiliaria_zanche_martin.R;

import com.devmhz.inmobiliaria_zanche_martin.modelo.Propietario;
import com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles.InmueblesViewModel;


public class PerfilFragment extends Fragment {

    private EditText etDni, etNombre, etApellido, etTelefono, etContraseña, etMail;
    private Button btEditar;
    private PerfilViewModel perfilViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        inicializarVista(root);

        perfilViewModel.getUsuario().observe(getViewLifecycleOwner(), new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
               // etDni.setText(propietario.getDni().toString());
                etDni.setText(propietario.getDni());
                etApellido.setText(propietario.getApellido());
                etNombre.setText(propietario.getNombre());
                etTelefono.setText(propietario.getTelefono());
                etMail.setText(propietario.getEmail());
                //etContraseña.setText(propietario.getContraseña());
            }
        });
        perfilViewModel.getEstado().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                etDni.setEnabled(aBoolean);
                etApellido.setEnabled(aBoolean);
                etNombre.setEnabled(aBoolean);
                etTelefono.setEnabled(aBoolean);
                etMail.setEnabled(aBoolean);
                etContraseña.setEnabled(aBoolean);
            }
        });

        perfilViewModel.getTextoBoton().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btEditar.setText(s);
            }
        });
        perfilViewModel.getMensaje().observe(getViewLifecycleOwner(),new Observer<String>() {
            @Override
            public void onChanged(String s) {
               //Toast.makeText(PerfilFragment.this,s, Toast.LENGTH_LONG).show();
                 Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
        perfilViewModel.traerDatos();
        return root;
    }

    private void inicializarVista(View root) {
        etDni=root.findViewById(R.id.etDniPerfil);
        etNombre=root.findViewById(R.id.etNombrePerfil);
        etApellido=root.findViewById(R.id.etApellidoPerfil);
        etTelefono=root.findViewById(R.id.etTelefonoPerfil);
        etMail=root.findViewById(R.id.etEmailPerfil);
        etContraseña=root.findViewById(R.id.etContraseñaPerfil);
        btEditar=root.findViewById(R.id.btEditarPerfil);

        btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Propietario propietario=new Propietario();
                //propietario.setDni(Long.parseLong(etDni.getText().toString()));
                propietario.setDni(etDni.getText().toString());
                propietario.setApellido(etApellido.getText().toString());
                propietario.setNombre(etNombre.getText().toString());
                propietario.setTelefono(etTelefono.getText().toString());
                propietario.setContraseña(etContraseña.getText().toString());
                propietario.setEmail(etMail.getText().toString());

                String texto=btEditar.getText().toString();
                perfilViewModel.accionBoton(texto,propietario);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}