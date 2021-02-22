package com.dam.takecare.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private int idImagen;
    private String titulo;
    //private String descripcion;

    public Item(int idImagen, String titulo, String descripcion) {
        this.idImagen = idImagen;
        this.titulo = titulo;
        //this.descripcion = descripcion;
    }

    protected Item(Parcel in) {
        idImagen = in.readInt();
        titulo = in.readString();
        //descripcion = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getIdImagen() {
        return idImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    /*public String getDescripcion() {
        return descripcion;
    }*/

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idImagen);
        dest.writeString(titulo);
        //dest.writeString(descripcion);
    }
}
