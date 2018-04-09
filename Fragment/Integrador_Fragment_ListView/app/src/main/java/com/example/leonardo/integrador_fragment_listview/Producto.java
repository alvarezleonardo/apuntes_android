package com.example.leonardo.integrador_fragment_listview;

import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 3/10/2016.
 */

public class Producto {
    private String nombre;
    private Float precio;
    private Integer foto;

    public String getNombre() {
        return nombre;
    }

    public Float getPrecio() {
        return precio;
    }

    public Integer getFoto() {
        return foto;
    }

    public Producto (String nombre, Float precio, Integer foto) {
        this.nombre = nombre;
        this.precio = precio;
        this.foto = foto;
    }

    public static List<Producto> ListProductos(){
        List<Producto> unaLista = new ArrayList<>();
        unaLista.add(new Producto("Vento modelo 2010 impecable", 285000.00f, R.drawable.vento));
        unaLista.add(new Producto("Vento modelo 2012 con detalles", 485000.00f, R.drawable.ventodos));
        unaLista.add(new Producto("Vento modelo 2014 para entendidos", 385000.00f, R.drawable.ventotres));
        unaLista.add(new Producto("Bora modelo 2010 impecable", 285000.00f, R.drawable.bora));
        unaLista.add(new Producto("Bora modelo 2012 con detalles", 485000.00f, R.drawable.borados));
        unaLista.add(new Producto("Bora modelo 2014 para entendidos", 385000.00f, R.drawable.boratres));
        unaLista.add(new Producto("Xasara picasso familiar unica modelo 2010 impecable", 285000.00f, R.drawable.xsara));
        unaLista.add(new Producto("Xasara picasso familiar unica modelo 2010 impecable", 285000.00f, R.drawable.xsarados));
        unaLista.add(new Producto("Xasara picasso familiar unica modelo 2010 impecable", 285000.00f, R.drawable.xsaratres));
        return unaLista;
    }


}
