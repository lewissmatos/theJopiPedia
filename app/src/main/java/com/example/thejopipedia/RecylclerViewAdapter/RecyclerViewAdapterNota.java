package com.example.thejopipedia.RecylclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.Notas;
import com.example.thejopipedia.R;

import java.util.ArrayList;

public class RecyclerViewAdapterNota  extends RecyclerView.Adapter<RecyclerViewAdapterNota.ViewHolder> {
    ArrayList<Notas> notas;
    Context context;

    public RecyclerViewAdapterNota(ArrayList<Notas> notas, Context context) {
        this.notas = notas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterNota.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_apuntes_design, parent, false);
        RecyclerViewAdapterNota.ViewHolder viewHolder = new RecyclerViewAdapterNota.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterNota.ViewHolder holder, int position) {
        holder.encabezado.setText(notas.get(position).getEncabezado());
        holder.contenido.setText(notas.get(position).getContenido());
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView encabezado, contenido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            encabezado = itemView.findViewById(R.id.encabezado);
            contenido = itemView.findViewById(R.id.contenido);
        }
    }
}
