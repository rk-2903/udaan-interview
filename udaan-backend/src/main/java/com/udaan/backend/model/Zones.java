package com.udaan.backend.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Deprecated
@Document(collection = "zones")
public class Zones {
    Map<String, String> map;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}
