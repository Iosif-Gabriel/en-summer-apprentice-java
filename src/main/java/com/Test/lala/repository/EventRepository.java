package com.Test.lala.repository;

import com.Test.lala.model.EventU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventU, Long> {
    List<EventU> findEventsByVenue_idVenueAndEventType_eventTypeName(Long idVenue, String eventTypeName);
}
