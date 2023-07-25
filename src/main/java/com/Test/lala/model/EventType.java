package com.Test.lala.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="EventType")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEventType",nullable = false)
    private Long idEventType;

    @Column(name="eventTypeName",nullable = false)
    private String eventTypeName;

    @OneToMany(mappedBy = "eventType")
    private List<EventU> events;

    public List<EventU> getEvents() {
        return events;
    }

    public void setEvents(List<EventU> events) {
        this.events = events;
    }

    public Long getIdEventType() {
        return idEventType;
    }

    public void setIdEventType(Long idEventType) {
        this.idEventType = idEventType;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public EventType() {
    }

    public EventType(Long idEventType, String eventTypeName) {
        this.idEventType = idEventType;
        this.eventTypeName = eventTypeName;
    }
}
