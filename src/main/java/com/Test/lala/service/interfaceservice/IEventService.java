package com.Test.lala.service.interfaceservice;

import com.Test.lala.model.EventU;

import java.util.List;

public interface IEventService {
    List<EventU> eventFindAll();

    EventU findById(Long id);

    List<EventU> getEventsByVenueIdAndEventType(Long venueId, String eventType);

    EventU getEventUById(Long eventId);
}
