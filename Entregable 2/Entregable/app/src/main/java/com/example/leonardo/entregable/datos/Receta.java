package com.example.leonardo.entregable.datos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 18/10/2016.
 */

public class Receta {
    private String nombre;
    private Integer foto;
    private Integer codigo;


    public Receta(String nombre, Integer foto, Integer codigo) {
        this.nombre = nombre;
        this.foto = foto;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getFoto() {
        return foto;
    }

    public static List<Receta> ObtenerReceta(){
        List<Receta> unListReceta = new ArrayList<>();
        unListReceta.add(new Receta("Camarones a los 4 quesos", 0, 1));
        unListReceta.add(new Receta("Mila napo", 0, 2));
        unListReceta.add(new Receta("Suprema Napo", 0, 3));
        unListReceta.add(new Receta("Todo napo", 0, 4));
        return unListReceta;
    }







}
