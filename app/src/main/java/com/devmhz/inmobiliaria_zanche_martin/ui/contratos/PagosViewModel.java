package com.devmhz.inmobiliaria_zanche_martin.ui.contratos;

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
import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Pago;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PagosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Pago>> pagos;
    Context context;
    public PagosViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<ArrayList<Pago>> getPagos() {
        if (pagos == null) {
            pagos = new MutableLiveData<>();
        }
        return pagos;
    }

    public void cargarPagosDeContratos(Bundle bundle) {
        Contrato contrato  = (Contrato) bundle.getSerializable("contrato");
        int contratoId= contrato.getIdContrato();
        //ApiClient api = ApiClient.getApi();
       // this.pagos.setValue(api.obtenerPagos(pagosLista));
        ArrayList<Pago> pagosList = new ArrayList<>();
        ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp= ApiClientRetrofit.conectar(context);
        Call<List<Pago>> pagosCall =apiClientRetrofit.pagosGetAllByIdContrato(contratoId,sp.getString("token","-1"));
        pagosCall.enqueue(new Callback<List<Pago>>() {
            @Override
            public void onResponse(Call<List<Pago>> call, Response<List<Pago>> response) {
                if (response.isSuccessful()){
                    response.body().forEach(e -> {
                        Pago pago= new Pago(e.getId(),e.getNroPago(),e.getImporte(),e.getFechaDePago(),e.getContratoId());
                        pagosList.add(pago);
                        /*inmueblesList.add(new Inmueble(e.getId(),e.getDireccion(),e.getUso(),e.getTipo(),e.getAmbientes(),
                                e.getPrecio(),e.getSuperficie(),e.getImagen()));*/
                    });

                    pagos.setValue((ArrayList<Pago>) pagosList);
                    Log.d("Exito al obtener pagos",response.toString());
                }

                else {
                    Log.d("Error al cargar pagos",response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Pago>> call, Throwable t) {
                Log.d("Error pagoss",t.toString());
            }

        });
    }
}