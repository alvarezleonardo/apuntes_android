package com.ejemplo.album.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by leona on 5/11/2016.
 */

public class Track {
    private Integer albumId, id;
    private String  title;
    @SerializedName("url")
    private String pictureUrl;
    @SerializedName("thumbnailUrl")
    private String pictureThumbnailUrl;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPictureThumbnailUrl() {
        return pictureThumbnailUrl;
    }

    public void setPictureThumbnailUrl(String pictureThumbnailUrl) {
        this.pictureThumbnailUrl = pictureThumbnailUrl;
    }
}
