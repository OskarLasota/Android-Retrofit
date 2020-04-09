package com.example.retrofit.Models.api;

import com.example.retrofit.Models.FlickrImage;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import com.google.gson.annotations.Expose;

public class Photos {

    @SerializedName("photo")
    @Expose
    private List<FlickrImage> photo = null;


    public List<FlickrImage> getPhotos() {
        return photo;
    }

}