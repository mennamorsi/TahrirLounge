package com.menna.officialtahrirlounge.classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by menna on 9/10/2017.
 */

public class Gallery
{
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("gallery")
    @Expose
    private String [] gallery;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGallery(int i)
    {
        return gallery[i];
    }
    public String [] getGallery()
    {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }
}
