package com.devmhz.inmobiliaria_zanche_martin.ui.inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inquilino;

public class InquilinoViewModel extends ViewModel {
    private MutableLiveData<Inquilino> inquilino;
    public InquilinoViewModel() {
        super();
    }

    public LiveData<Inquilino> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle) {
        Inmueble inmueble  = (Inmueble) bundle.getSerializable("inmueble");
        //ApiClient api = ApiClient.getApi();
      //  this.inquilino.setValue(api.obtenerInquilino(inmueble));
    }
}