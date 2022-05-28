package com.devmhz.inmobiliaria_zanche_martin.ui.contratos;

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

import com.devmhz.inmobiliaria_zanche_martin.R;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Contrato;
import com.devmhz.inmobiliaria_zanche_martin.modelo.Pago;


import java.util.List;

public class PagosAdapter extends RecyclerView.Adapter<PagosAdapter.ViewHolder> {

    private Context context;
    private List<Pago> pagos;
    private LayoutInflater inflater;
    Contrato contratoPago;

    public PagosAdapter(Context context, List<Pago> pagos, LayoutInflater inflater) {
        this.context = context;
        this.pagos = pagos;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_detalle_pago, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvCodigoPago.setText(pagos.get(position).getId() + "");
        holder.tvNumeroPago.setText(pagos.get(position).getNroPago()+"");
        holder.tvCodigoContratoPagos.setText(pagos.get(position).getContratoId()+"");
        holder.tvFechaPago.setText(pagos.get(position).fechaPago()+"");
        holder.tvImporte.setText("$" + pagos.get(position).getImporte());
        contratoPago = pagos.get(position).getContrato();
    }

    @Override
    public int getItemCount() {
        return pagos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvCodigoPago , tvNumeroPago, tvCodigoContratoPagos, tvImporte, tvFechaPago;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCodigoContratoPagos = itemView.findViewById(R.id.tvCodigoContratoPagos);
            tvCodigoPago = itemView.findViewById(R.id.tvCodigoPago);
            tvNumeroPago = itemView.findViewById(R.id.tvNumeroPago);
            tvImporte = itemView.findViewById(R.id.tvImporte);
            tvFechaPago = itemView.findViewById(R.id.tvFechaPago);
          /*  itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    Contrato cont = contratoPago;
                    bundle.putSerializable("contrato", cont);
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.pagosFragment, bundle);
                }
            });*/
        }
    }
}
