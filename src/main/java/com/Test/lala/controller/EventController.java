package com.Test.lala.controller;

import com.Test.lala.model.EventU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.EventService;
import com.Test.lala.service.dto.EventDTO;
import com.Test.lala.service.mapper.EventToEventDToMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

 /*   @GetMapping("/events2")
    public List<EventDTO> getAllEvents() {
        List<EventU> events = eventService.eventFindAll();
        return EventToEventDToMapper.convert(events);
    }*/

    @GetMapping("/findEventId/{id}")
    public EventU findEventById(@PathVariable Long id) {
        EventU eventU = new EventU();
        try {
            eventU = eventService.findById(id);
        } catch (EntityNotFoundException e) {
            System.out.println("Event not found");
        }
        return eventU;
    }

    @GetMapping("/events")
    public List<EventDTO> getAllEvents(@RequestParam("idVenue") Long venueId, @RequestParam("eventTypeName") String eventType) {
        List<EventU> events = eventService.getEventsByVenueIdAndEventType(venueId, eventType);
        return events.stream().map(EventToEventDToMapper::convertReq).collect(Collectors.toList());
    }

}
