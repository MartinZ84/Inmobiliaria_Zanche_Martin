package com.devmhz.inmobiliaria_zanche_martin.Request;

import android.content.Context;
import android.content.SharedPreferences;

import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Pago;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Propietario;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public class ApiClientRetrofit {

    //private static final String URLBASE="http://practicastuds.ulp.edu.ar/api/";
    private static final String URLBASE="http://192.168.0.13:5000/api/";
    private static  RetrofitService myApiInteface;
    private static SharedPreferences sp;


    public static SharedPreferences conectar(Context context){
        if(sp==null){
            sp=context.getSharedPreferences("Datos",0);
        }
        return sp;
    }

    public static RetrofitService getMyApiClient(){

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(URLBASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(RetrofitService.class);

        return myApiInteface;
    }



    public interface RetrofitService{
        //PROPIETARIOS
        //login
        @POST("Propietarios/login")
        Call<String> login(@Body Usuario usuario );
        //Call<String> login(@Body Propietario propietario);

        //Datos propietario logueado/
        @GET("Propietarios")
        Call<Propietario> propietario(@Header("Authorization") String token);

        //Datos propietario logueado/
        @PUT("Propietarios")
        Call<Propietario> propietarioPut(@Body Propietario propietario,@Header("Authorization") String token);


        //INMUEBLES
        //@GET("Inmuebles/0")
        @GET("Inmuebles")
        Call<List<Inmueble>> inmueblesPropietarioList(@Header("Authorization") String token);

        @PUT("Inmuebles/CambiarEstado/{id}")
        Call<Inmueble> inmuebleCambiarDisponibilidad(@Path("id") int id ,@Body Inmueble inmueble,@Header("Authorization") String token);



        @GET("Inmuebles/{id}")
        Call<Inmueble>inmueblesById(@Path("id") int id, @Header("Authorization") String token);

        //CONTRATOS
        @GET("Contratos")
        Call<List<Contrato>>contratosGetAll(@Header("Authorization") String token);
        @GET("Contratos/Vigentes")
        Call<List<Contrato>>contratosGetAllVigentes(@Header("Authorization") String token);

        //PAGOS
        @GET("Pagos/{id}")
        Call<List<Pago>>pagosGetAllByIdContrato(@Path("id") int id ,@Header("Authorization") String token);


    }

}
