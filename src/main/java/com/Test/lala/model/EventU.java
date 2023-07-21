package com.Test.lala.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="EventU")
public class EventU {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEvent",nullable = false)
    private Long idEvent;

    @ManyToOne
    @JoinColumn(name = "idVenue", nullable = false)
    private Venue venue;

    @ManyToOne
    @JoinColumn(name = "idEventType", nullable = false)
    private EventType eventType;

    @Column(name="eventName",nullable = false)
    private String eventName;

    @Column(name="descriptionEvent",nullable = false)
    private String descriptionEvent;

    @Column(name="startDate",nullable = false)
    private Date startDate;

    @Column(name="endDate",nullable = false)
    private Date endDate;

    @OneToMany(mappedBy = "event")
    private List<TicketCategory> ticketCategories;

    public Long getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Long idEvent) {
        this.idEvent = idEvent;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescriptionEvent() {
        return descriptionEvent;
    }

    public void setDescriptionEvent(String descriptionEvent) {
        this.descriptionEvent = descriptionEvent;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public EventU() {
    }

    public EventU(Long idEvent, Venue venue, EventType eventType, String eventName, String descriptionEvent, Date startDate, Date endDate) {
        this.idEvent = idEvent;
        this.venue = venue;
        this.eventType = eventType;
        this.eventName = eventName;
        this.descriptionEvent = descriptionEvent;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketCategories = new ArrayList<>();
    }

    public Venue getVenue() {
        return venue;
    }


    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public List<TicketCategory> getTicketCategories() {
        return ticketCategories;
    }

    public void setTicketCategories(List<TicketCategory> ticketCategories) {
        this.ticketCategories = ticketCategories;
    }
}
