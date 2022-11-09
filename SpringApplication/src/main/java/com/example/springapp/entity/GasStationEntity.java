package com.example.springapp.entity;

import javax.persistence.*;

@Entity
@Table(name = "gas_stations")
public class GasStationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false,length = 50)
    private String name;

    @Column(name = "location", nullable = false,length = 250)
    private String location;

    @Column(name = "working_hours",nullable = false)
    private String working_hours;

    @Column(name = "phone_number",nullable = false)
    private String phone_number;

    public GasStationEntity(String name, String location, String working_hours, String phone_number) {
        this.name = name;
        this.location = location;
        this.working_hours = working_hours;
        this.phone_number = phone_number;
    }

    public GasStationEntity() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
