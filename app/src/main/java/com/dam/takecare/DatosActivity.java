package com.dam.takecare;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dam.takecare.model.Item;

public class DatosActivity extends AppCompatActivity {

    ImageView iv;
    TextView tvTituloDat;
   // TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        iv = findViewById(R.id.ivDatos);
        tvTituloDat = findViewById(R.id.tvTituloDatos);
       //tvDesc = findViewById(R.id.tvDescDatos);

        Item elemento = getIntent().getParcelableExtra(MainActivity.CLAVE_DATOS);

        iv.setImageResource(elemento.getIdImagen());
        tvTituloDat.setText(elemento.getTitulo());
       // tvDesc.setText(elemento.getDescripcion());
    }
}