package com.example.thejopipedia.RecylclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.EditarApuntesActivity;
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
        if (notas.get(position).getContenido().length() > 30){
            String texto = notas.get(position).getContenido().substring(0, 30);
            holder.contenido.setText(texto + "…");
        }
        else {
            holder.contenido.setText(notas.get(position).getContenido());
        }
            holder.id.setText(notas.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView encabezado, contenido, id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, EditarApuntesActivity.class);
                    Bundle b = new Bundle();
                    b.putString("id", id.getText().toString());
                    i.putExtras(b);
                    context.startActivity(i);
                }
            });

            encabezado = itemView.findViewById(R.id.encabezado);
            contenido = itemView.findViewById(R.id.contenido);
            id = itemView.findViewById(R.id.id);
        }
    }
}
