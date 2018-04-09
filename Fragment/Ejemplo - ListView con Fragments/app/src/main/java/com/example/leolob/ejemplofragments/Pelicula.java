package com.example.leolob.ejemplofragments;

import java.util.ArrayList;

/**
 * Created by leolob on 1/5/16.
 */
public class Pelicula {

    String _Titulo, _nombrePersonajeProtagonico, _nombreActorProtagonico;

    public  Pelicula (String Titulo, String nombrePersonajeProtagonico, String nombreActorProtagonico) {
        this._Titulo=Titulo;
        this._nombrePersonajeProtagonico=nombrePersonajeProtagonico;
        this._nombreActorProtagonico=nombreActorProtagonico;
    }

    public String get_Titulo() {
        return this._Titulo;
    }

    public String get_nombreActorProtagonico() {
        return  this._nombreActorProtagonico;
    }

    public  String get_nombrePersonajeProtagonico() {
        return  this._nombrePersonajeProtagonico;
    }

    public  String toString() {
        return  this._Titulo+" - "+this._nombrePersonajeProtagonico;
    }


    public static ArrayList<Pelicula> obtenerListaDePeliculas() {
        ArrayList listaADevolver;

        listaADevolver=new ArrayList<Pelicula>();

        listaADevolver.add(new Pelicula("Volver al futuro", "Marty McFly", "Michael Fox"));
        listaADevolver.add(new Pelicula("Indiana Jones", "Indiana Jones", "Harrison Ford"));
        listaADevolver.add(new Pelicula("Forrest Gump", "Forrest Gump", "Tom Hanks"));
        listaADevolver.add(new Pelicula("Rocky", "Rocky Balboa", "Sylvester Stallone"));
        listaADevolver.add(new Pelicula("Rambo", "John Rambo", "Sylvester Stallone"));
        listaADevolver.add(new Pelicula("Terminator", "Cyberdyne 101", "Arnold Schwarzenegger"));
        listaADevolver.add(new Pelicula("Rescatando al soldado Ryan", "Capt. John Miller", "Tom Hanks"));
        listaADevolver.add(new Pelicula("Matrix", "Neo", "Keanu Reevs"));
        listaADevolver.add(new Pelicula("Toy Story", "Woody", "Tom Hanks"));
        listaADevolver.add(new Pelicula("El día de la marmota", "Phill Connors", "Bill Murray"));
        listaADevolver.add(new Pelicula("Titanic", "Jack Dawson", "Leonardo DiCaprio"));
        listaADevolver.add(new Pelicula("Piratas del Caribe", "Jack Sparrow", "Jonny Depp"));
        listaADevolver.add(new Pelicula("Avatar", "Jake Sully", "Sam Worthington"));
        listaADevolver.add(new Pelicula("El Señor de los anillos", "Frodo Bolsón", "Elija Wood"));
        listaADevolver.add(new Pelicula("Shrek", "Shrek", "Mike Myers"));
        listaADevolver.add(new Pelicula("Star Wars", "Luke Skywalker", "Mark Hamill"));

        return listaADevolver;

    }


}


