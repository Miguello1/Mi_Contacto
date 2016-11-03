package com.miguel.micontacto;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.Intent;
import java.text.DateFormat;
import java.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.TextInputEditText;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


public class MainActivity extends AppCompatActivity {


    private  TextInputEditText hint_nombre;
    private  TextInputEditText hint_fecha;
    private  TextInputEditText hint_telefono;
    private  TextInputEditText hint_email;
    private  TextInputEditText hint_descripcion;

    private int mYear, mMonth, mDay;

    Button siguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hint_nombre         = (TextInputEditText) findViewById(R.id.hint_nombre);
        hint_fecha          = (TextInputEditText) findViewById(R.id.hint_fecha);
        hint_telefono       = (TextInputEditText) findViewById(R.id.hint_telefono);
        hint_email          = (TextInputEditText) findViewById(R.id.hint_email);
        hint_descripcion    = (TextInputEditText) findViewById(R.id.hint_descripcion);

        siguiente = (Button) findViewById(R.id.siguiente);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
                i.putExtra(getResources().getString(R.string.pnombre), hint_nombre.getEditableText().toString());
                i.putExtra("fecha", hint_fecha.getEditableText().toString());
                i.putExtra(getResources().getString(R.string.ptelefono), hint_telefono.getEditableText().toString());
                i.putExtra(getResources().getString(R.string.pemail), hint_email.getEditableText().toString());
                i.putExtra(getResources().getString(R.string.pdescripcion), hint_descripcion.getEditableText().toString());
                startActivity(i);

            }
        });


        Bundle parametrosEditados = getIntent().getExtras();
        if (parametrosEditados != null) {// to avoid the NullPointerException
                String name         = parametrosEditados.getString("nombre");
                String fecha        = parametrosEditados.getString("fecha");
                String phone        = parametrosEditados.getString("telefono");
                String mail         = parametrosEditados.getString("email");
                String description  = parametrosEditados.getString("descripcion");

                hint_nombre.setText(name);
                hint_fecha.setText(fecha);
                hint_telefono.setText(phone);
                hint_email.setText(mail);
                hint_descripcion.setText(description);
        }
    }

    public void showDatePickerDialog(View v) {

        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        hint_fecha.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);

        datePickerDialog.show();
    }


}

