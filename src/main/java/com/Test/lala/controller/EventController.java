package com.Test.lala.controller;

import com.Test.lala.model.EventU;
import com.Test.lala.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    private EventService eventService;
    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

        @GetMapping("/events")
        public List<EventU> getAllEvents(){
            return eventService.eventFindAll();
        }
}
