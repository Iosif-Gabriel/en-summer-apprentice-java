package com.Test.lala.service;

import com.Test.lala.controller.EventController;
import com.Test.lala.model.EventU;
import com.Test.lala.repository.EventRepository;
import com.Test.lala.service.interfaceservice.IEventService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements IEventService {

    private EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventU> eventFindAll(){
        return eventRepository.findAll();
    }

    public EventU findById(Long id){
        Optional<EventU> eventFindById=eventRepository.findById(id);
        if(eventFindById.isPresent()){
            return eventFindById.get();
        }
      else{
          throw new EntityNotFoundException("Event not found "+eventFindById);
        }
    }

    public List<EventU> getEventsByVenueIdAndEventType(Long venueId, String eventType) {
        return eventRepository.findEventsByVenue_idVenueAndEventType_eventTypeName(venueId, eventType);
    }

    public EventU getEventUById(Long eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }


}
