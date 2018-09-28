package com.example.franck.mapchain.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Step {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("image_uuid")
    @Expose
    private String imageUuid;
    @SerializedName("text")
    @Expose
    private String text;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageUuid() {
        return imageUuid;
    }

    public void setImageUuid(String imageUuid) {
        this.imageUuid = imageUuid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
