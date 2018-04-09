package com.example.leonardo.momadh.model;

/**
 * Created by leona on 28/11/2016.
 */

public class Paints {
    private String image, name;
    private Artists artists;

    public Artists getArtists() {
        return artists;
    }

    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
