package com.example.franck.mapchain;

import com.example.franck.mapchain.models.ContractModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ServerParser implements Parser{
    public List<ContractModel> contractModels;
    public final static String URL = "http://192.168.43.227:3000/contract";

    public List parseJson(String json) throws Exception{
        contractModels = new ArrayList<>();
        JSONArray jsonarray = new JSONArray(json);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            int id = jsonobject.getInt("id");
            String address = jsonobject.getString("address");
            String price = jsonobject.getString("price");
            String lat = jsonobject.getString("lat");
            String log = jsonobject.getString("long");
            String description = jsonobject.getString("description");
            contractModels.add(new ContractModel(id, address, price,lat,log,description));
        }

        return contractModels;
    }

    @Override
    public void parser(String s) {

    }
}
