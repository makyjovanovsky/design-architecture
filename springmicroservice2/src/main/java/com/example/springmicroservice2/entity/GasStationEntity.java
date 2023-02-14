package com.example.springmicroservice2.entity;

public class GasStationEntity {

    private Long id;


    private String city;


    private String location;


    private String working_hours;


    private String phone_number;


    private double latitude;


    private double longitude;

    public GasStationEntity(String city, String location, String working_hours, String phone_number, double latitude, double longitude) {
        this.city = city;
        this.location = location;
        this.working_hours = working_hours;
        this.phone_number = phone_number;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public GasStationEntity() {

    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWorking_hours() {
        return working_hours;
    }

    public void setWorking_hours(String working_hours) {
        this.working_hours = working_hours;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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
}

