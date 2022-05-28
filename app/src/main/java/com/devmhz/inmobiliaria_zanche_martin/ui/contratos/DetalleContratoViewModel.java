package com.devmhz.inmobiliaria_zanche_martin.ui.contratos;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;


public class DetalleContratoViewModel extends AndroidViewModel {
    private MutableLiveData<Contrato> contrato;

    public DetalleContratoViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<Contrato> getContrato() {
        if (contrato == null) {
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void cargarInmuebleAlquilados(Bundle bundle) {
      //  Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        //ApiClient api = ApiClient.getApi();
        //this.contrato.setValue(api.obtenerContratoVigente(inmueble));
        Contrato contrato = (Contrato) bundle.getSerializable("contrato");
        this.contrato.setValue(contrato);
    }

}