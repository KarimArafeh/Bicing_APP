package com.example.y2793623b.bicing_app;

/**
 * Created by y2793623b on 31/01/17.
 */

public class Bicing {



    private String id;
    private String type;
    private String latitude;
    private String streetName;
    private String streetNumber;
    private String altitude;
    private String slots;
    private String bikes;
    private String nearbyStations;
    private String status;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getBikes() {
        return bikes;
    }

    public void setBikes(String bikes) {
        this.bikes = bikes;
    }

    public String getNearbyStations() {
        return nearbyStations;
    }

    public void setNearbyStations(String nearbyStations) {
        this.nearbyStations = nearbyStations;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bicing{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", latitude='" + latitude + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", altitude='" + altitude + '\'' +
                ", slots='" + slots + '\'' +
                ", bikes='" + bikes + '\'' +
                ", nearbyStations='" + nearbyStations + '\'' +
                ", status='" + status + '\'' +
                '}';
    }


}
