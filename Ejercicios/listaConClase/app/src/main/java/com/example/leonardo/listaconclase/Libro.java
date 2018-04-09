package com.example.leonardo.listaconclase;

import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 26/9/2016.
 */

public class Libro {
    private String isbn;
    private String titulo, autor;
    private Double precio;
    private Integer idFoto;

    public Libro(String pisbn, String pautor, String ptitulo, Double pprecio, Integer pidfoto){
        isbn = pisbn;
        titulo = ptitulo;
        autor = pautor;
        precio = pprecio;
        idFoto = pidfoto;
    }

    public Integer getIdFoto() {
        return idFoto;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Double getPrecio() {
        return precio;
    }

    //static decimos que es metodo de clase y no de objeto, entonces se puede acceder sin instanciar
    public static List<Libro> obtenerLibro (){
        List<Libro> unaLista = new ArrayList<>();

        unaLista.add(new Libro("978-987-722-186-2", "Golpe en Brasil", "Pablo Gentili", 249.00, R.drawable.ff9789877221862));
        unaLista.add(new Libro("978-987-1891-20-7", "Encuentros entre reformas sociales, salud, pobreza y desigualdad en América Latina", "Carlos Fidel. Enrique Valencia ", 458.50, R.drawable.f978987189107));
        unaLista.add(new Libro("978-987-1891-21-4", "Encuentros entre reformas sociales, salud, pobreza y desigualdad en América Latina\n" +
                "Tomo II", "Pablo Gentili", 219.00, R.drawable.f9789871891214));
        unaLista.add(new Libro("852490803-3", "A cidadania negada", "CLACSO. Cortez", 399.90, R.drawable.f8524908033));

        return unaLista;

    }

}
