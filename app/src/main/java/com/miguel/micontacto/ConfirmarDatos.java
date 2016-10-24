package com.miguel.micontacto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros   = getIntent().getExtras();

        String name         = parametros.getString(getResources().getString(R.string.pnombre));
        String phone        = parametros.getString(getResources().getString(R.string.ptelefono));
        String mail         = parametros.getString(getResources().getString(R.string.pemail));
        String description  = parametros.getString(getResources().getString(R.string.pdescripcion));

        TextView tvNombre       = (TextView) findViewById(R.id.nombre);
        TextView tvTelefono     = (TextView) findViewById(R.id.telefono);
        TextView tvEmail        = (TextView) findViewById(R.id.email);
        TextView tvDescripcion  = (TextView) findViewById(R.id.descripcion);


        tvNombre.setText(name);
        tvTelefono.setText(phone);
        tvEmail.setText(mail);
        tvDescripcion.setText(description);


    }
}
