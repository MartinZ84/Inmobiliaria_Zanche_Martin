package com.devmhz.inmobiliaria_zanche_martin.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmhz.inmobiliaria_zanche_martin.Request.ApiClientRetrofit;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Propietario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PerfilViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> estado;
    private MutableLiveData<String> textoBoton;
    private MutableLiveData<Propietario> propietario;
    private MutableLiveData<String> mensaje;
    private Context context;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }


    public LiveData<Boolean> getEstado(){
        if(estado==null){
            estado=new MutableLiveData<>();
        }
        return estado;
    }

    public LiveData<String> getTextoBoton(){
        if(textoBoton==null){
            textoBoton=new MutableLiveData<>();
        }
        return textoBoton;
    }
    public LiveData<Propietario> getUsuario(){
        if(propietario==null){
            propietario=new MutableLiveData<>();
        }
        return propietario;
    }


    public LiveData<String> getMensaje(){
        if(mensaje==null){
            mensaje=new MutableLiveData<>();
        }
        return mensaje;
    }


    public void accionBoton(String txtBoton, Propietario propietario){

        if(txtBoton.equals("Editar")){
            textoBoton.setValue("Guardar");
            estado.setValue(true);
        }else{
            textoBoton.setValue("Editar");
            estado.setValue(false);
//            ApiClient apiClient=ApiClient.getApi();
//            apiClient.actualizarPerfil(propietario);
            ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
            SharedPreferences sp= ApiClientRetrofit.conectar(context);
            Log.d("Shared preferences",sp.getString("token","-1"));
            Call<Propietario> prop=apiClientRetrofit.propietarioPut(propietario,sp.getString("token","-1"));
            prop.enqueue(new Callback<Propietario>() {
                @Override
                public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                    if (response.isSuccessful()) {
                        mensaje.setValue("Usuario actualizado correctamente");
                    } else {
                        Log.d("Error update", response.toString());
                        mensaje.setValue("No de pudo actualizar datos");
                    }
                }
                @Override
                public void onFailure(Call<Propietario> call, Throwable t) {
                    Log.d("Token",t.toString());
                }
            });
        }
    }

    public void traerDatos(){
//        ApiClient apiClient=ApiClient.getApi();
//        usuario.setValue(apiClient.obtenerUsuarioActual());
        ApiClientRetrofit.RetrofitService apiClientRetrofit=ApiClientRetrofit.getMyApiClient();
        SharedPreferences sp= ApiClientRetrofit.conectar(context);
        Log.d("Shared preferences",sp.getString("token","-1"));
        Call<Propietario> prop=apiClientRetrofit.propietario(sp.getString("token","-1"));
        prop.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if (response.isSuccessful()){
                    Propietario p= new Propietario(response.body().getId(),response.body().getDni(), response.body().getNombre(),
                            response.body().getApellido(),response.body().getEmail(),response.body().getContraseña(),response.body().getTelefono());
                    propietario.setValue(p);
                }
                else {
                    Log.d("Error al cargar perfil",response.toString());
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Log.d("Token",t.toString());
            }
        });


    }
}