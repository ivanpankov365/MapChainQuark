package com.example.franck.mapchain.models;

import java.io.Serializable;

public class ContractModel implements Serializable{
    private int id;
    private String address;
    private String price;
    private String lat;
    private String log;
    private String description;

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public ContractModel(int id, String address, String price, String lat, String log, String description) {
        this.id = id;
        this.address = address;
        this.price = price;
        this.lat = lat;
        this.log = log;
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

}
