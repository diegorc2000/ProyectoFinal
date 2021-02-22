package com.dam.takecare.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.takecare.R;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ItemViewHolder> {

    private ArrayList<Item> datos;

    public Adaptador(ArrayList<Item> datos) {
        this.datos = datos;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                             int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindItem(datos.get(position));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView titulo;
        private TextView descripcion;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imageView);
            titulo = itemView.findViewById(R.id.tvTitulo);
            //descripcion = itemView.findViewById(R.id.tvDescripcion);
        }

        public void bindItem(Item item) {
            imagen.setImageResource(item.getIdImagen());
            titulo.setText(item.getTitulo());
            //descripcion.setText(item.getDescripcion());
        }
    }
}
