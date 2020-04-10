package com.example.thejopipedia.RecylclerViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thejopipedia.BiologiaActivity;
import com.example.thejopipedia.R;

import java.util.ArrayList;

public class RecylclerViewAdapter extends RecyclerView.Adapter<RecylclerViewAdapter.ViewHolder> {
    ArrayList<Tema> temas;
    Context context;

    public RecylclerViewAdapter(ArrayList<Tema> temas, Context context) {
        this.temas = temas;
        this.context = context;
    }

    @NonNull
    @Override
    public RecylclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design , parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecylclerViewAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(temas.get(position).getImage());
        holder.tittle.setText(temas.get(position).getTittle());
        holder.desc.setText(temas.get(position).getDesc());
        holder.tittle.setTextColor(ContextCompat.getColor(context, temas.get(position).getColor()));
        holder.rltLayout.setBackgroundResource(temas.get(position).getColor());
    }

    @Override
    public int getItemCount() {
        return temas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView tittle, desc;
        RelativeLayout rltLayout;
        LinearLayout parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, BiologiaActivity.class);
                    Bundle b = new Bundle();
                    b.putInt("id", getAdapterPosition());
                    i.putExtras(b);
                    context.startActivity(i);
                }
            });

            image = itemView.findViewById(R.id.imgage);
            tittle = itemView.findViewById(R.id.tittle);
            desc = itemView.findViewById(R.id.desc);
            rltLayout = itemView.findViewById(R.id.rltLayout);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
