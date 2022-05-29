package com.devmhz.inmobiliaria_zanche_martin.ui.inquilinos;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmhz.inmobiliaria_zanche_martin.Request.ApiClientRetrofit;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inquilino;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InquilinosViewModel extends AndroidViewModel {


    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private MutableLiveData<ArrayList<Contrato>> contratos;
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

    public LiveData<ArrayList<Contrato>> getContratos() {
        if (contratos == null) {
            contratos = new MutableLiveData<ArrayList<Contrato>>();
        }
        return contratos;
    }

    public void cargarInmueblesAlquilados() {
        //Acá traemos todos los inmuebles de la base de datos
        //ApiClient api=ApiClient.getApi();
        // ArrayList<Inmueble> inmuebles=api.obtenerPropiedadesAlquiladas();
        //  this.inmuebles.setValue(inmuebles);
        ArrayList<Contrato> contratoList = new ArrayList<>();
        ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp= ApiClientRetrofit.conectar(context);
        Call<List<Contrato>> contratosCall =apiClientRetrofit.contratosGetAll(sp.getString("token","-1"));
        contratosCall.enqueue(new Callback<List<Contrato>>() {
            @Override
            public void onResponse(Call<List<Contrato>> call, Response<List<Contrato>> response) {
                if (response.isSuccessful()){
                    response.body().forEach(e -> {
                        Contrato contrato= new Contrato(e.getIdContrato(),e.getFechaInicio(),e.getFechaFin(),
                                e.getPrecio(),e.getEstado(),e.getInquilino(), e.getInmueble(),e.getNombre_Garante(),e.getApellido_Garante(),
                                e.getTelefono_Garante());
                        contratoList.add(contrato);
                        /*inmueblesList.add(new Inmueble(e.getId(),e.getDireccion(),e.getUso(),e.getTipo(),e.getAmbientes(),
                                e.getPrecio(),e.getSuperficie(),e.getImagen()));*/
                    });

                    contratos.setValue((ArrayList<Contrato>) contratoList);
                    Log.d("Exito Contratos desde inquilinos",response.toString());
                }

                else {
                    Log.d("Error al cargar contratos",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Contrato>> call, Throwable t) {
                Log.d("Error",t.toString());
            }

        });

    }
}