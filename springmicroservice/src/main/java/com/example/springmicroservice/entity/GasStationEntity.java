package com.example.springmicroservice.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "gas_stations")
public class GasStationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "location", nullable = false, length = 250)
    private String location;

    @Column(name = "working_hours", nullable = false)
    private String working_hours;

    @Column(name = "phone_number", nullable = false)
    private String phone_number;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
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

