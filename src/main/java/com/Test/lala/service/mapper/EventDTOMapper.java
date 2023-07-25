package com.Test.lala.service.mapper;

import com.Test.lala.model.EventU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.model.dto.EventDTO;
import com.Test.lala.model.dto.TicketCategoryDTO;
import com.Test.lala.model.dto.VenueDTO;

import java.util.ArrayList;
import java.util.List;

public class EventDTOMapper{

  public static EventDTO convertReq(EventU event) {
      EventDTO eventDTO = new EventDTO();
      eventDTO.setEventID(event.getIdEvent());
      eventDTO.setVenue(new VenueDTO(event.getVenue()));

      if (event.getEventType() != null && event.getEventType().getEventTypeName() != null) {
          eventDTO.setEventName(event.getEventType().getEventTypeName());
          eventDTO.setEventType(event.getEventType().getEventTypeName());
      }

      eventDTO.setEventDescription(event.getDescriptionEvent());
      eventDTO.setEventName(event.getEventName());
      eventDTO.setEventStartDate(event.getStartDate());
      eventDTO.setEventEndDate(event.getEndDate());
      List<TicketCategoryDTO> ticketCategoryDTOList = new ArrayList<>();
      for (TicketCategory ticketCategory : event.getTicketCategories()) {
          TicketCategoryDTO ticketCategoryDTO=new TicketCategoryDTO(ticketCategory);
          ticketCategoryDTOList.add(ticketCategoryDTO);
      }
      eventDTO.setTicketCategoriesDTO(ticketCategoryDTOList);
      return eventDTO;
  }







}
