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

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder>
implements View.OnClickListener {

    private ArrayList<Item> dato;
    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public void setListener(View.OnClickListener listener){
        this.listener = listener;
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView titulo;
        private TextView descripcion;

        public MiViewHolder(View itemView) { //clase interna que hace referencia a los componentes de un layout
            super(itemView);
            imagen = itemView.findViewById(R.id.imageView);
            titulo = itemView.findViewById(R.id.tvTitulo);
            //descripcion = itemView.findViewById(R.id.tvDescripcion);
        }

        public void bindListaItem(Item item) {
            imagen.setImageResource(item.getIdImagen());
            titulo.setText(item.getTitulo());
            //descripcion.setText(item.getDescripcion());
        }
    }

    public MiAdaptador(ArrayList<Item> datos) {
        this.dato = datos;
    }


    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        v.setOnClickListener(this);
        MiViewHolder ivh = new MiViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int posicion) {
        holder.bindListaItem(dato.get(posicion));
    }

    @Override
    public int getItemCount() {

        return dato.size();
    }

}
