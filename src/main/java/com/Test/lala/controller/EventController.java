package com.Test.lala.controller;

import com.Test.lala.model.EventU;
import com.Test.lala.service.EventService;
import com.Test.lala.model.dto.EventDTO;
import com.Test.lala.service.mapper.EventDTOMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/findEventId/{id}")
    public EventDTO findEventById(@PathVariable Long id) {
        EventU eventU = eventService.findById(id);
        EventDTO eventDTO= new EventDTO();
        try {

            eventDTO = new EventDTO(eventU);
        } catch (EntityNotFoundException e) {
            System.out.println("Event not found");
        }
        return eventDTO;
    }

    @GetMapping("/events")
    public List<EventDTO> getEventVenueType(@RequestParam("idVenue") Long venueId, @RequestParam("eventTypeName") String eventType) {
        List<EventU> events = eventService.getEventsByVenueIdAndEventType(venueId, eventType);
        return events.stream().map(EventDTOMapper::convertReq).collect(Collectors.toList());
    }

}
