package com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;


public class InmuebleViewModel extends ViewModel {
    private MutableLiveData<Inmueble> inmueble;
    public InmuebleViewModel() {
        super();
    }

    public LiveData<Inmueble> getInmueble() {
        if (inmueble == null) {
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }

    public void cargarInmueble(Bundle bundle) {
        Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        this.inmueble.setValue(inmueble);
    }

}