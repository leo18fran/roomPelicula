package com.example.roomapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText tttitulo, ttdescripcion, ttgenero, ttdirector;
    PeliculaDB db;
    TextView tvmostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tttitulo =findViewById(R.id.txttitulo);
        ttdescripcion =findViewById(R.id.txtdescripcion);
        ttgenero =findViewById(R.id.txtgenero);
        ttdirector =findViewById(R.id.txtdirector);

         db = Room.databaseBuilder(getApplicationContext(), PeliculaDB.class, "Peliculas.db")
                 .allowMainThreadQueries()
                 .build();

        tvmostrar = findViewById(R.id.textView);
        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas = db.peliculaDao().allpeliculas();
        tvmostrar.setText("");
        for (Pelicula item: peliculas){
            tvmostrar.append("titulo: "+item.titulo+ "\n"+
                    "Descripcion: "+item.descripcion+ "\n"+
                    "Genero: "+item.genero+ "\n"+
                    "Director: "+item.director+ "\n"
            );
        }
    }

    public void GuardarInfo(View view) {

        String titulo =tttitulo.getText().toString();
        String descripcion =ttdescripcion.getText().toString();
        String genero =ttgenero.getText().toString();
        String director =ttdirector.getText().toString();


        Pelicula pelicula = new Pelicula();
        pelicula.titulo = titulo;
        pelicula.descripcion = descripcion;
        pelicula.genero = genero;
        pelicula.director = director;
        db.peliculaDao().InsertarPelicula(pelicula);

        Toast.makeText(getApplicationContext(),"Pelicula guardada", Toast.LENGTH_LONG).show();
    }
}