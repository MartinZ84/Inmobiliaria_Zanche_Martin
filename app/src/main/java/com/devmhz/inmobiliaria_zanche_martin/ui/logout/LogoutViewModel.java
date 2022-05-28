package com.devmhz.inmobiliaria_zanche_martin.ui.logout;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.devmhz.inmobiliaria_zanche_martin.R;

/*public class LogoutViewModel extends AndroidViewModel {
    private Context context;
    private Application application;


    public LogoutViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
        application.a
    }


    // TODO: Implement the ViewModel
    public void mostrarDialog(){
        new AlertDialog.Builder(context)
                .setTitle("Titulo")
                .setMessage("Desea cerrar la app")
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);

                    }
                }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Navigation.findNavController(getA, R.id.nav_host_fragment_content_main).navigate(R.id.nav_inicio);

            }
        }).show();
    }


}*/

public class LogoutViewModel extends AndroidViewModel {
    private MutableLiveData<AlertDialog.Builder> mutableDialogBuilder;

    private Context context;
    private Application application;
    public LogoutViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        this.application = application;
    }

    public LiveData<AlertDialog.Builder> getMutableDialogBuilder() {
        if(mutableDialogBuilder == null){
            mutableDialogBuilder = new MutableLiveData<>();
        }
        return mutableDialogBuilder;
    }

    public void mostrarDialog(){
        AlertDialog.Builder alertDialog =  new AlertDialog.Builder(application)
                .setTitle("Titulo")
                .setMessage("Desea cerrar la app")
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.exit(0);

                    }
                }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.nav_inicio);

                    }
                });
        mutableDialogBuilder.setValue(alertDialog);
    }
    // TODO: Implement the ViewModel
}