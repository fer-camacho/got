package com.example.got;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etPassword;
    Button btnCrearUsuario, btnIniciarSesion;
    Switch swRecordarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        swRecordarUsuario = findViewById(R.id.swRecordarUsuario);
        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("TODO", "Se apreto el boton iniciar sesion.");
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                if (usuario.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "COMPLETAR DATOS", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(LoginActivity.this, SeleccionElementosActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "CREAR USUARIO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}