package com.example.leonardo.momadh.model;

import java.util.List;

/**
 * Created by leona on 28/11/2016.
 */

public class Artists {
    private String name;
    private List<Paints> paints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Paints> getPaints() {
        return paints;
    }

    public void setPaints(List<Paints> paints) {
        this.paints = paints;
    }
}
