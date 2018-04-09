package com.example.digitalhouse.repasorecycleryfragments;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digitalhouse on 21/10/16.
 */
public class Receta {

    private String nombre;
    private String decripcion;
    private Integer foto;

    public Receta(String nombre, String decripcion, Integer foto) {
        this.nombre = nombre;
        this.decripcion = decripcion;
        this.foto = foto;
    }

    public static List<Receta> dameRecetas(){
        List<Receta> listaADevolver = new ArrayList<>();

        listaADevolver.add(new Receta("Churros1", "con ddl", R.drawable.churros));
        listaADevolver.add(new Receta("Churros2", "con ddl", R.drawable.churros));
        listaADevolver.add(new Receta("Churros3", "con ddl", R.drawable.churros));
        listaADevolver.add(new Receta("Churros4", "con ddl", R.drawable.churros));
        listaADevolver.add(new Receta("Churros5", "con ddl", R.drawable.churros));
        listaADevolver.add(new Receta("Churros6", "con ddl", R.drawable.churros));
        listaADevolver.add(new Receta("Churros7", "con ddl", R.drawable.churros));

        return listaADevolver;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDecripcion() {
        return decripcion;
    }

    public void setDecripcion(String decripcion) {
        this.decripcion = decripcion;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
