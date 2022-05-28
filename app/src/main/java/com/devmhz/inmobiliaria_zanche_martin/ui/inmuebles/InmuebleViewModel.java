package com.devmhz.inmobiliaria_zanche_martin.ui.inmuebles;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devmhz.inmobiliaria_zanche_martin.Request.ApiClientRetrofit;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Propietario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InmuebleViewModel extends AndroidViewModel {
    private MutableLiveData<Inmueble> inmueble;
    Context context;
    private MutableLiveData<String> mensaje;
    Inmueble inmuebleBundle;

    public InmuebleViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();

    }

    public LiveData<Inmueble> getInmueble() {
        if (inmueble == null) {
            inmueble = new MutableLiveData<>();
        }
        return inmueble;
    }
    public LiveData<String> getMensaje(){
        if(mensaje==null){
            mensaje=new MutableLiveData<>();
        }
        return mensaje;
    }

    public void cargarInmueble(Bundle bundle) {
        //Inmueble inmueble = (Inmueble) bundle.getSerializable("inmueble");
        inmuebleBundle = (Inmueble) bundle.getSerializable("inmueble");
        this.inmueble.setValue(inmuebleBundle);
    }

    public void cambiarDisponibilidad(boolean b){

        inmuebleBundle.setEstadoInmueble(b);
        ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp= ApiClientRetrofit.conectar(context);
        Call<Inmueble> callInm=apiClientRetrofit.inmuebleCambiarDisponibilidad(inmuebleBundle.getId(),inmuebleBundle,sp.getString("token","-1"));
        callInm.enqueue(new Callback<Inmueble>() {
            @Override
            public void onResponse(Call<Inmueble> call, Response<Inmueble> response) {
                if (response.isSuccessful()) {
                    mensaje.setValue("Disponibilidad del inmueble actualizada correctamente");
                } else {
                    Log.d("Error al actualizar disponibilidad del inmueble ", response.toString());
                    mensaje.setValue("Error al actualizar disponibilidad del inmueble");
                }
            }

            @Override
            public void onFailure(Call<Inmueble> call, Throwable t) {
                Log.d("Error disponibilidad", t.toString());
            }
        });
    }
}