package com.miguel.micontacto;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    private  TextInputEditText hint_nombre;
    private  TextInputEditText hint_telefono;
    private  TextInputEditText hint_email;
    private  TextInputEditText hint_descripcion;

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hint_nombre = (TextInputEditText) findViewById(R.id.hint_nombre);
        hint_telefono = (TextInputEditText) findViewById(R.id.hint_telefono);
        hint_email = (TextInputEditText) findViewById(R.id.hint_email);
        hint_descripcion = (TextInputEditText) findViewById(R.id.hint_descripcion);


        siguiente = (Button) findViewById(R.id.siguiente);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
                i.putExtra(getResources().getString(R.string.pnombre),hint_nombre.getEditableText().toString());
                i.putExtra(getResources().getString(R.string.ptelefono),hint_telefono.getEditableText().toString());
                i.putExtra(getResources().getString(R.string.pemail),hint_email.getEditableText().toString());
                i.putExtra(getResources().getString(R.string.pdescripcion),hint_descripcion.getEditableText().toString());
                startActivity(i);

            }
        });

    }
}
