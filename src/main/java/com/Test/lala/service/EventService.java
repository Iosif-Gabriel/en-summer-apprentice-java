package com.Test.lala.service;

import com.Test.lala.controller.EventController;
import com.Test.lala.model.EventU;
import com.Test.lala.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventU> eventFindAll(){
        return eventRepository.findAll();
    }
}
