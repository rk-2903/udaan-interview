package com.udaan.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "zones")
public class Zones {
    Map<String, String> map; //pincode, color

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
