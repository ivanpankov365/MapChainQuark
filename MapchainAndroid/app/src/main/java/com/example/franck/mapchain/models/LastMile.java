package com.example.franck.mapchain.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LastMile {

    @SerializedName("steps")
    @Expose
    private List<Step> steps = null;
    @SerializedName("type")
    @Expose
    private String type;

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}