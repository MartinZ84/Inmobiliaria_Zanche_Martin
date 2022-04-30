package com.devmhz.inmobiliaria_zanche_martin.ui.inquilinos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devmhz.inmobiliaria_zanche_martin.Request.ApiClient;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inquilino;

import java.util.ArrayList;

public class InquilinosViewModel extends AndroidViewModel {


    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<Inquilino> inquilino;
    private Context context;
    public InquilinosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }
    public LiveData<Inquilino> getInquilino() {
        if (inquilino == null) {
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInmueblesAlquilados() {
        //Acá traemos todos los inmuebles de la base de datos
        ApiClient api=ApiClient.getApi();
        ArrayList<Inmueble> inmuebles=api.obtenerPropiedadesAlquiladas();
        this.inmuebles.setValue(inmuebles);

    }
}