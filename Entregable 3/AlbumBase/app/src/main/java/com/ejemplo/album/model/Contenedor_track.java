package com.ejemplo.album.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leona on 5/11/2016.
 */

public class Contenedor_track {
    @SerializedName("albums")
    private List<Track> trackList;

    public List<Track> getResults() {

        return trackList;
    }

    public void setTackList(List<Track> trackList) {
        this.trackList = trackList;
    }

}
