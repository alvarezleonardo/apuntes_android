package com.example.digitalhouse.parserbase.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leona on 26/10/2016.
 */

public class Contenedor {

    @SerializedName("results")
    private List<Canales> canalesList;

    public List<Canales> getCanalesList() {
        return canalesList;
    }

}
