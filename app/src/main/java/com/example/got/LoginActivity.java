package com.example.got;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    Toolbar login_toolbar;
    EditText etUsuario, etPassword;
    Button btnCrearUsuario, btnIniciarSesion;
    Switch swRecordarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_toolbar = findViewById(R.id.login_toolbar);
        setSupportActionBar(login_toolbar);
        getSupportActionBar().setTitle("Game of Thrones");

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        swRecordarUsuario = findViewById(R.id.swRecordarUsuario);
        btnCrearUsuario = findViewById(R.id.btnCrearUsuario);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
        String usuarioGuardado = prefs.getString(Constantes.USUARIO, null);
        String passGuardada = prefs.getString(Constantes.PASSWORD, null);

        if (usuarioGuardado != null && passGuardada!= null) {
            iniciarSeleccionElementosActivity(usuarioGuardado);
        }

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i("TODO", "Se apreto el boton iniciar sesion.");
                String usuario = etUsuario.getText().toString();
                String password = etPassword.getText().toString();

                if (usuario.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Complete username", Toast.LENGTH_SHORT).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Complete password", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        login(usuario, password);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        btnCrearUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CrearCuentaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void login(String usuario, String password) throws Exception {
        try{
            Usuario user = UsuarioManager.getInstancia(LoginActivity.this).traer(UsuarioManager.getInstancia(LoginActivity.this).getUsuarios(), usuario);
            if (user == null) {
                etUsuario.setText("");
                Toast.makeText(LoginActivity.this, "Username does not exist", Toast.LENGTH_SHORT).show();
            } else {
                //Usuario user = UsuarioManager.getInstancia(LoginActivity.this).traer(UsuarioManager.getInstancia(LoginActivity.this).getUsuarios(), usuario);
                //if ((user != null) && (user.getPassword().equals(password))){
                if (user.getPassword().equals(password)) {
                    if(swRecordarUsuario.isChecked()) {
                        SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString(Constantes.USUARIO, usuario);
                        editor.putString(Constantes.PASSWORD, password);
                        editor.apply();
                    }
                    iniciarSeleccionElementosActivity(usuario);
                } else {
                    etPassword.setText("");
                    Toast.makeText(LoginActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void iniciarSeleccionElementosActivity(String usuarioGuardado) {
        Intent intent = new Intent(LoginActivity.this, SeleccionElementosActivity.class);
        intent.putExtra(Constantes.USUARIO, usuarioGuardado);
        startActivity(intent);
        finish();
    }
}