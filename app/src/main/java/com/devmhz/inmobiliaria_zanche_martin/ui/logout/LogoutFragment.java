package com.devmhz.inmobiliaria_zanche_martin.ui.logout;

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
import com.devmhz.inmobiliaria_zanche_martin.ui.contratos.ContratosViewModel;

public class LogoutFragment extends Fragment {

    private TextView tvLogOut;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LogoutViewModel logoutFragment =
                new ViewModelProvider(this).get(LogoutViewModel.class);



        View root = inflater.inflate(R.layout.fragment_logout, container, false);
        tvLogOut=root.findViewById(R.id.tvLogout);
        tvLogOut.setText("Este es el fragment Logout");



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}