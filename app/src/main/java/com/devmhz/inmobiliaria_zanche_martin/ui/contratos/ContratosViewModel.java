package com.devmhz.inmobiliaria_zanche_martin.ui.contratos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devmhz.inmobiliaria_zanche_martin.Request.ApiClient;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;

import java.util.ArrayList;




    public class ContratosViewModel extends AndroidViewModel {

        private MutableLiveData<ArrayList<Inmueble>> inmuebles;
        private Context context;
        public ContratosViewModel(@NonNull Application application) {
            super(application);
            context = application.getApplicationContext();

        }

        public LiveData<ArrayList<Inmueble>> getInmuebles() {
            if (inmuebles == null) {
                inmuebles = new MutableLiveData<>();
            }
            return inmuebles;
        }

        public void cargarInmueblesAlquilados() {
            //Acá traemos todos los inmuebles de la base de datos
            ApiClient api=ApiClient.getApi();
            ArrayList<Inmueble> inmuebles=api.obtenerPropiedadesAlquiladas();
            this.inmuebles.setValue(inmuebles);

        }
    }