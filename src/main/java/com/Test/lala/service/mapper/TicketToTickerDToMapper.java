package com.Test.lala.service.mapper;

import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.dto.TicketCategoryDTO;

import java.util.ArrayList;
import java.util.List;

public class TicketToTickerDToMapper {

    public static TicketCategoryDTO req(TicketCategory category){
        TicketCategoryDTO ticketCategoryDTO=new TicketCategoryDTO();
        ticketCategoryDTO.setIdTicketCategory(category.getIdTicketCategory());
        ticketCategoryDTO.setPrice(category.getPrice());
        ticketCategoryDTO.setDescriptionEventCategory(category.getDescriptionEventCategory());
        ticketCategoryDTO.setEventID(category.getEvent().getIdEvent());
        return ticketCategoryDTO;
    }

    public static List<TicketCategory> reqToEntityList(List<TicketCategoryDTO> ticketCategoryDTOList) {
        List<TicketCategory> ticketCategoryList = new ArrayList<>();

        for (TicketCategoryDTO ticketCategoryDTO : ticketCategoryDTOList) {
            TicketCategory ticketCategory = new TicketCategory();
            ticketCategory.setIdTicketCategory(ticketCategoryDTO.getIdTicketCategory());
            ticketCategory.setPrice(ticketCategoryDTO.getPrice());
            ticketCategory.setDescriptionEventCategory(ticketCategoryDTO.getDescriptionEventCategory());

            ticketCategoryList.add(ticketCategory);
        }

        return ticketCategoryList;
    }
}
