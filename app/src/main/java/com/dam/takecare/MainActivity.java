package com.dam.takecare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.takecare.model.Datos;
import com.dam.takecare.model.Item;
import com.dam.takecare.model.MiAdaptador;

public class MainActivity extends AppCompatActivity {

    public static final String CLAVE_DATOS = "DATOS";
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rvListado);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        final Datos datos = new Datos();
        MiAdaptador ad = new MiAdaptador(datos.getDatos());
        ad.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = rv.indexOfChild(v);
                Item elemento = datos.getDatos().get(i);

                Intent intentDatos = new Intent(getApplicationContext(), DatosActivity.class);
                intentDatos.putExtra(CLAVE_DATOS, elemento);
                startActivity(intentDatos);
            }
        });
        rv.setAdapter(ad);

    }
}