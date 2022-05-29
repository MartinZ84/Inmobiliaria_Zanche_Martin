package com.devmhz.inmobiliaria_zanche_martin.ui.inquilinos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.devmhz.inmobiliaria_zanche_martin.R;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inmueble;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Inquilino;

import java.util.List;

public class InquilinoAdapter extends RecyclerView.Adapter<InquilinoAdapter.ViewHolder> {
    private Context context;
    private List<Inmueble> inmuebles;
    private LayoutInflater inflater;
    private List<Contrato> contratos;




   // public InquilinoAdapter(Context context, List<Inmueble> inmuebles, LayoutInflater inflater) {
   public InquilinoAdapter(Context context, List<Contrato> contratos, LayoutInflater inflater) {
        this.context = context;
        this.inmuebles = inmuebles;
       this.contratos = contratos;
       // this.inquilino= inquilino;
        this.inflater = inflater;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_inquilino_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvDireccion.setText(contratos.get(position).toString());
        holder.tvInquilino.setText("Inquilino/a: "+contratos.get(position).getInquilino().getNombre() +" " +contratos.get(position).getInquilino().getApellido());
        holder.tvFechaInicio.setText("Contrato desde "+ contratos.get(position).fechaInicioOnly() + " hasta " + contratos.get(position).fechaFinOnly() );
        //holder.tvFechaFin.setText(contratos.get(position).fechaFin());
        //holder.tvInquilino.setText("" + inquilino.getNombre());
        Glide.with(context)
                .load(contratos.get(position).getInmueble().getFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivImagenInmueble);
    }

    @Override
    public int getItemCount() {
        //return inmuebles.size();
        return contratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInquilino;
        TextView tvDireccion;
        ImageView ivImagenInmueble;
        TextView tvFechaInicio,tvFechaFin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenInmueble = itemView.findViewById(R.id.ivImagenInmueble);
            tvInquilino = itemView.findViewById(R.id.tvInquilino);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvFechaInicio=itemView.findViewById(R.id.tvFechaInicio);
            tvFechaFin=itemView.findViewById(R.id.tvFechaFin);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    //Inmueble inmueble = inmuebles.get(getAdapterPosition());
                    Contrato contrato = contratos.get(getAdapterPosition());
                    //bundle.putSerializable("inmueble", inmueble);
                    bundle.putSerializable("contrato", contrato);

                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.inquilinoFragment, bundle);
                }
            });
        }
    }
}










