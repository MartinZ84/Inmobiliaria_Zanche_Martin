package com.devmhz.inmobiliaria_zanche_martin;

import static android.content.Context.SENSOR_SERVICE;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmhz.inmobiliaria_zanche_martin.Request.ApiClient;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Propietario;

import java.util.List;

public class LoginViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> mensaje;
    private SensorManager sensorManager;
    private LeeSensor leeSensor;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();

    }

    public LiveData<String> getMensaje(){
        if(mensaje==null){
            mensaje=new MutableLiveData<>();
        }
        return mensaje;

    }

    public void iniciarSesion(String usuario,String contraseña){

        ApiClient api=ApiClient.getApi();
        Propietario propietarioLogueado=api.login(usuario,contraseña);
        if(propietarioLogueado!=null){
            //Inicio la Activity del menú
            Intent intent=new Intent(context,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            //Desregistro el sensor despues del login para que no pueda accionarse despues
            sensorManager.unregisterListener(leeSensor);
        } else{
            mensaje.setValue("Usuario y/o Contraseña incorrecto!!!");
        }
    }

    public void obtenerSensores(){
        leeSensor=new LeeSensor();
        sensorManager = (SensorManager) context.getSystemService(SENSOR_SERVICE);
        //sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if(listaSensores.size()>0){
            sensorManager.registerListener(leeSensor,listaSensores.get(0),SensorManager.SENSOR_DELAY_GAME);
        }
    }



    private class LeeSensor implements SensorEventListener {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(sensorEvent.values[0] > 20){
                Uri tel = Uri.parse("tel:113");
                //CUANDO SE LLAMA A STARTACTIVITY DESDE FUERA DE UNA ACTIVITY SE DEBE AÑADIR EL FLAG :FLAG_ACTIVITY_NEW_TASK
                //https://elbauldelprogramador.com/solucionar-android-calling-startactivity-from-outside-of-an-activity-context-requires-the-flag_activity_new_task-flag/
                context.startActivity(new Intent(Intent.ACTION_CALL, tel).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));

            }
            //Log.d("Salida", ""+ sensorEvent.values.length);

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }



}

