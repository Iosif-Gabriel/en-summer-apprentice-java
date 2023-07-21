package com.Test.lala.service.dto;

import com.Test.lala.model.Venue;

public class VenueDTO {

    public VenueDTO() {

    }

    private Long idVenue;
    private String venueLocation;
    private String venueType;
    private int venueCapacity;

    public VenueDTO(Venue venue) {
        this.idVenue = venue.getIdVenue();
        this.venueLocation = venue.getVenueLocation();
        this.venueType = venue.getVenueType();
        this.venueCapacity = Integer.parseInt(venue.getVenueCapacity());
    }

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

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public void setVenueCapacity(int venueCapacity) {
        this.venueCapacity = venueCapacity;
    }
}
