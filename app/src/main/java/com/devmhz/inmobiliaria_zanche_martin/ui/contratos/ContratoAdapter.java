package com.devmhz.inmobiliaria_zanche_martin.ui.contratos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.List;

public class ContratoAdapter extends RecyclerView.Adapter<ContratoAdapter.ViewHolder> {
    private Context context;
    private List<Inmueble> inmuebles;
    private LayoutInflater inflater;
    private List<Contrato> contratos;



    public ContratoAdapter(Context context, List<Contrato> contratos, LayoutInflater inflater) {
        this.context = context;
        this.contratos = contratos;
        this.inflater = inflater;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_contrato_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDireccion.setText(contratos.get(position).toString());
        holder.tvFechaInicio.setText(contratos.get(position).fechaInicio());
        holder.tvFechaFin.setText(contratos.get(position).fechaFin());


        // holder.btVerContrato.setText("Ver contrato");
        Glide.with(context)
                .load(contratos.get(position).getInmueble().getFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivImagenInmueble);
    }

    @Override
    public int getItemCount() {
        return contratos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       // Button btVerContrato;
        TextView tvDireccion;
        ImageView ivImagenInmueble;
        TextView tvFechaInicio, tvFechaFin;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImagenInmueble = itemView.findViewById(R.id.ivImagenInmueble);
          //  btVerContrato = itemView.findViewById(R.id.btVerContrato);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            tvFechaInicio=itemView.findViewById(R.id.tvFechaInicio);
            tvFechaFin=itemView.findViewById(R.id.tvFechaFin);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Contrato contrato = contratos.get(getAdapterPosition());
                    bundle.putSerializable("contrato", contrato);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.detalleContratoFragment, bundle);
                }
            });
        }
    }
}










