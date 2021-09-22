package com.udaan.backend.dto;

public class ZoneWiseResult {

    private String numCases;
    private String zoneType;

    public ZoneWiseResult(String numCases, String zoneType) {
        this.numCases = numCases;
        this.zoneType = zoneType;
    }
}
