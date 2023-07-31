package com.Test.lala.service.interfaceservice;

import com.Test.lala.model.TicketCategory;

import java.util.List;

public interface ITicketService {
    List<TicketCategory> getFindAllTickets();

    TicketCategory getTicketCategoryById(Long id);


}
