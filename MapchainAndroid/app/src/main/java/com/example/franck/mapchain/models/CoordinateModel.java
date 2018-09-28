package com.example.franck.mapchain.models;

public class CoordinateModel {
   private Double longitute;
   private Double latitude;

    public Double getLongitute() {
        return longitute;
    }

    public void setLongitute(Double longitute) {
        this.longitute = longitute;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public CoordinateModel(Double longitute, Double latitude) {

        this.longitute = longitute;
        this.latitude = latitude;
    }
}
