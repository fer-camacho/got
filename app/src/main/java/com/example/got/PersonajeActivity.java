package com.example.got;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Person;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonajeActivity extends AppCompatActivity {
    Toolbar personaje_toolbar;
    ImageView imgItem;
    TextView tvFirstName, tvLastName, tvFulltName, tvTitle, tvFamily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);



        Personaje personaje = (Personaje) getIntent().getSerializableExtra("personaje");

        tvFirstName = findViewById(R.id.tvFirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvFulltName = findViewById(R.id.tvFullName);
        tvTitle = findViewById(R.id.tvTitle);
        tvFamily = findViewById(R.id.tvFamily);
        imgItem = findViewById(R.id.imgItem);

        tvFirstName.setText("First Name: "+personaje.getFirstName());
        tvLastName.setText("Last Name: "+personaje.getLastName());
        //tvFulltName.setText(personaje.getFullName());
        tvTitle.setText("Title: "+personaje.getTitle());
        tvFamily.setText("Family: "+personaje.getFamily());
        imgItem.setImageResource(personaje.getImgResource());

        personaje_toolbar = findViewById(R.id.personaje_toolbar);
        setSupportActionBar(personaje_toolbar);
        getSupportActionBar().setTitle(personaje.getFirstName() + " " + personaje.getLastName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_personaje, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.item_volver){
            Intent intent = new Intent(PersonajeActivity.this, MainActivity.class);
            intent.putExtra("cantidad", getIntent().getIntExtra("cantidad", 0));
            startActivity(intent);
            finish();
        } else {
            SharedPreferences prefs = getApplicationContext().getSharedPreferences(Constantes.SP_CREDENCIALES, MODE_PRIVATE);
            prefs.edit().clear().apply();
            Intent intent = new Intent(PersonajeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}