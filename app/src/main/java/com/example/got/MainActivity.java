package com.example.got;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvPersonajes;
    PersonajeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvPersonajes = findViewById(R.id.rvPersonajes);
        setupAdapter();
    }

    private void setupAdapter() {
        rvPersonajes = findViewById(R.id.rvPersonajes);
        adapter = new PersonajeAdapter(getPersonajes().subList(0, getIntent().getIntExtra("cantidad", 0)), new PersonajeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Personaje personaje) {
                Intent intent = new Intent(MainActivity.this, PersonajeActivity.class);
                intent.putExtra("personaje", personaje);
                startActivity(intent);
            }
        });
        rvPersonajes.setAdapter(adapter);
    }

    private List<Personaje> getPersonajes() {
        List<Personaje> personajes = new ArrayList<Personaje>();
        personajes.add(new Personaje(1, "Daenerys", "Targaryen", "Daenerys Targaryen", "Mother of Dragons","House Targaryen", R.drawable.daenerys));
        personajes.add(new Personaje(2, "Samwell", "Tarly", "Samwell Tarly", "Maester", "House Tarly", R.drawable.sam));
        personajes.add(new Personaje(3, "Jon", "Snow", "Jon Snow", "King of the North", "House Stark", R.drawable.jon));
        personajes.add(new Personaje(4, "Arya", "Stark", "Arya Stark", "No One", "House Stark", R.drawable.arya));
        personajes.add(new Personaje(5, "Sansa", "Stark", "Sansa Stark", "Lady of Winterfell", "House Stark", R.drawable.sansa));
        personajes.add(new Personaje(6, "Brandon", "Stark", "Brandon Stark", "Lord of Winterfell", "House Stark", R.drawable.bran));
        personajes.add(new Personaje(7, "Ned", "Stark", "Ned Stark", "Lord of Winterfell", "House Stark", R.drawable.ned));
        personajes.add(new Personaje(8, "Robert", "Baratheon", "Robert Baratheon", "Lord of the Seven Kingdoms", "House Baratheon", R.drawable.robert));
        return personajes;
    }
}