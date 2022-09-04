package com.example.got;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeleccionElementosActivity extends AppCompatActivity {

    EditText etCantidad;
    Button btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_elementos);

        etCantidad = findViewById(R.id.etCantidad);
        etCantidad.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "8")}); //para que podamos limitar la cantidad de registros
        btnBuscar = findViewById(R.id.btnBuscar);

        btnBuscar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SeleccionElementosActivity.this, MainActivity.class);
                intent.putExtra("cantidad", Integer.valueOf(etCantidad.getText().toString()));
                startActivity(intent);
            }
        });

    }
}