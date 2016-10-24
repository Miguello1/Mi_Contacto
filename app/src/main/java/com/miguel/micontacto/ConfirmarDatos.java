package com.miguel.micontacto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    Button btn_editar;
    TextView tvNombre;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();

        String name = parametros.getString(getResources().getString(R.string.pnombre));
        String phone = parametros.getString(getResources().getString(R.string.ptelefono));
        String mail = parametros.getString(getResources().getString(R.string.pemail));
        String description = parametros.getString(getResources().getString(R.string.pdescripcion));

        tvNombre = (TextView) findViewById(R.id.nombre);
        tvTelefono = (TextView) findViewById(R.id.telefono);
        tvEmail = (TextView) findViewById(R.id.email);
        tvDescripcion = (TextView) findViewById(R.id.descripcion);

        tvNombre.setText(name);
        tvTelefono.setText(phone);
        tvEmail.setText(mail);
        tvDescripcion.setText(description);


        btn_editar = (Button) findViewById(R.id.btn_editar);

        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent(ConfirmarDatos.this, MainActivity.class);
                y.putExtra("nombre", tvNombre.getText().toString());
                y.putExtra("telefono", tvTelefono.getText().toString());
                y.putExtra("email", tvEmail.getText().toString());
                y.putExtra("descripcion", tvDescripcion.getText().toString());
                startActivity(y);

            }
        });

    }

}
