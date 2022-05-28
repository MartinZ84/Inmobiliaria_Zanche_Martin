package com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmhz.inmobiliaria_zanche_martin.Request.ApiClientRetrofit;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmueblesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;
    public InmueblesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles == null) {
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmuebles() {
        //Acá traemos todos los inmuebles de la base de datos
       /* ApiClient api=ApiClient.getApi();
        ArrayList<Inmueble> inmuebles=api.obtnerPropiedades();
        this.inmuebles.setValue(inmuebles);*/
        ArrayList<Inmueble> inmueblesList = new ArrayList<>();
        ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp= ApiClientRetrofit.conectar(context);
        Log.d("Shared preferences",sp.getString("token","-1"));
        Call<List<Inmueble>> inmuebleCall =apiClientRetrofit.inmueblesPropietarioList(sp.getString("token","-1"));
        inmuebleCall.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if (response.isSuccessful()){
                    response.body().forEach(e -> {
                        Inmueble i= new Inmueble(e.getId(),e.getDireccion(),e.getUso(),e.getTipo(),e.getAmbientes(),
                        e.getPrecio(),e.getSuperficie(),e.getEstado(),e.isEstadoInmueble(), e.getImagen());
                     inmueblesList.add(i);

                    });

                    inmuebles.setValue((ArrayList<Inmueble>) inmueblesList);
                }
                else {
                    Log.d("Error al cargar inmuebles",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
            }

        });


    }
}