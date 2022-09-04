package com.example.got;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonajeActivity extends AppCompatActivity {
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

    }
}