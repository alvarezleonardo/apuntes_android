package com.example.leonardo.entregable.datos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leona on 18/10/2016.
 */

public class Receta_detalle {
    private String insumo;
    private Integer cantidad;

    public Receta_detalle(String insumo, Integer cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }

    public String getInsumo() {
        return insumo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public static List<Receta_detalle> ObtenerRecetaDetalle(Integer codProducto) {
        List<Receta_detalle> recetaUno = new ArrayList<>();
        recetaUno.add(new Receta_detalle("Cacao", 12));
        recetaUno.add(new Receta_detalle("Cacao2", 12));
        recetaUno.add(new Receta_detalle("Cacao3", 12));
        recetaUno.add(new Receta_detalle("Cacao4", 12));
        return recetaUno;
    }

}
