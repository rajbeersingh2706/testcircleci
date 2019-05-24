package com.salido.labor.dto;

public class Location {

    private String locationId;
    private String locationName;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return " locationName=" + locationName + ", locationId=" + locationId;
    }

}