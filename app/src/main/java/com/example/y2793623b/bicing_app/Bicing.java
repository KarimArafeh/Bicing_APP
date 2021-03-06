package com.example.y2793623b.bicing_app;

/**
 * Created by y2793623b on 31/01/17.
 */

public class Bicing {



    private int id;
    private String type;
    private double latitude;
    private double longitude;
    private String streetName;
    //private int streetNumber;
    //private int altitude;
    private int slots;
    private int bikes;
    private String nearbyStations;
    //private String status;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public String getNearbyStations() {
        return nearbyStations;
    }

    public void setNearbyStations(String nearbyStations) {
        this.nearbyStations = nearbyStations;
    }



    @Override
    public String toString() {
        return "Bicing{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", streetName='" + streetName + '\'' +
                ", slots=" + slots +
                ", bikes=" + bikes +
                ", nearbyStations='" + nearbyStations + '\'' +
                '}';
    }
}
