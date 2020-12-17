package com.example.roomapp;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PeliculaDao {

    @Query("SELECT * FROM Pelicula")
    public List<Pelicula> allpeliculas();

    @Insert
    public void InsertarPelicula(Pelicula ... peliculas);

    @Update
    public void ActualizarPelicula(Pelicula ... peliculas);

    @Delete
    public void BorrarPelicula(Pelicula ... peliculas);
}
