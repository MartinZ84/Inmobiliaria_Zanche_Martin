package com.devmhz.inmobiliaria_zanche_martin.ui.inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inquilino;

public class InquilinoViewModel extends ViewModel {
    private MutableLiveData<Contrato> inquilino;

    public InquilinoViewModel() {
        super();
    }

    public LiveData<Contrato> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle) {
        Contrato contrato  = (Contrato) bundle.getSerializable("contrato");
        //ApiClient api = ApiClient.getApi();
       this.inquilino.setValue(contrato);

    }
}