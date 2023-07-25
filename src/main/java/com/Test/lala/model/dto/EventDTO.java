package com.Test.lala.model.dto;

import com.Test.lala.model.EventU;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonSerialize
public class EventDTO {
    public EventDTO() {
    }

    private Long eventID;
    private String eventDescription;
    private String eventName;
    private Date eventStartDate;
    private Date eventEndDate;
    private VenueDTO venueDTO;
    private String eventTypeName;
    private List<TicketCategoryDTO> ticketCategoriesDTO;

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public List<TicketCategoryDTO> getTicketCategoriesDTO() {
        return ticketCategoriesDTO;
    }

    public void setTicketCategoriesDTO(List<TicketCategoryDTO> ticketCategoriesDTO) {
        this.ticketCategoriesDTO = ticketCategoriesDTO;
    }

    public EventDTO(EventU event) {
        this.eventID = event.getIdEvent();
        this.eventDescription = event.getDescriptionEvent();
        this.eventName = event.getEventName();
        this.eventStartDate = event.getStartDate();
        this.eventEndDate = event.getEndDate();
        this.venueDTO = new VenueDTO();
        this.eventTypeName = event.getEventType().getEventTypeName();
        this.ticketCategoriesDTO = new ArrayList<>();

    }


    public Long getEventID() {
        return eventID;
    }

    public void setEventID(Long eventID) {
        this.eventID = eventID;
    }

    public String getEventDescription(String descriptionEvent) {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getGetEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date getEventEndDate) {
        this.eventEndDate = getEventEndDate;
    }

    public VenueDTO getVenueDTO() {
        return venueDTO;
    }

    public void setVenue(VenueDTO venueDTO) {
        this.venueDTO = venueDTO;
    }

    public String getEventType() {
        return eventTypeName;
    }

    public void setEventType(String eventType) {
        this.eventTypeName = eventType;
    }

}


