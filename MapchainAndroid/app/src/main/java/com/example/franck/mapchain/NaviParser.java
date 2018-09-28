package com.example.franck.mapchain;

import com.example.franck.mapchain.models.CoordinateModel;
import com.example.franck.mapchain.models.Id;
import com.example.franck.mapchain.models.Result;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NaviParser implements Parser {
    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getAddresss() {
        return addresss;
    }

    public void setAddresss(String addresss) {
        this.addresss = addresss;
    }

    private String container = "7";
    private String addresss = "703498";
    public final static String URL = "https://staging-api.naviaddress.com/api/v1.5/addresses/";

    @Override
    public void parser(String s) {

    }

    public CoordinateModel parserCoordinates(String s) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Id result = gson.fromJson(s, Id.class);
        return new CoordinateModel(result.getResult().getPoint().getLat(), result.getResult().getPoint().getLng());
    }

    public Result parserRes(String s) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Id result = gson.fromJson(s, Id.class);
        return result.getResult();
    }
}
