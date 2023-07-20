package com.Test.lala.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Venue")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idVenue")
    private Long idVenue;

    @Column(name="venueLocation")
    private String venueLocation;

    @Column(name="venueType")
    private String venueType;

    @Column(name="venueCapacity")
    private String venueCapacity;

    @OneToMany(mappedBy = "venue")
    private List<EventU> events;

    public Long getIdVenue() {
        return idVenue;
    }

    public void setIdVenue(Long idVenue) {
        this.idVenue = idVenue;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

    public String getVenueType() {
        return venueType;
    }

    public void setVenueType(String venueType) {
        this.venueType = venueType;
    }

    public String getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(String venueCapacity) {
        this.venueCapacity = venueCapacity;
    }

    public Venue() {
    }

    public Venue(Long idVenue, String venueLocation, String venueType, String venueCapacity) {
        this.idVenue = idVenue;
        this.venueLocation = venueLocation;
        this.venueType = venueType;
        this.venueCapacity = venueCapacity;
    }
}
