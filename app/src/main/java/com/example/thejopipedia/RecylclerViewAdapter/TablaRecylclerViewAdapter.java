package com.example.thejopipedia.RecylclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.R;

import java.util.ArrayList;

public class TablaRecylclerViewAdapter extends RecyclerView.Adapter<TablaRecylclerViewAdapter.ViewHolder> {
    ArrayList<Tabla> tabla;
    Context context;

    public TablaRecylclerViewAdapter(ArrayList<Tabla> tabla, Context context) {
        this.tabla = tabla;
        this.context = context;
    }

    @NonNull
    @Override
    public TablaRecylclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabla_cards_design , parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TablaRecylclerViewAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(tabla.get(position).getImage());
        holder.tittle.setText(tabla.get(position).getTittle());
        holder.puntuacion.setText(tabla.get(position).getPuntuacion());
        holder.tittle.setTextColor(ContextCompat.getColor(context, tabla.get(position).getColorbar()));
        holder.bar.setBackgroundResource(tabla.get(position).getColorbar());
    }

    @Override
    public int getItemCount() {
        return tabla.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView tittle, puntuacion;
        LinearLayout bar;
        LinearLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imgmg);
            tittle = itemView.findViewById(R.id.tittle);
            puntuacion = itemView.findViewById(R.id.puntuacion);
            bar = itemView.findViewById(R.id.bar);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
