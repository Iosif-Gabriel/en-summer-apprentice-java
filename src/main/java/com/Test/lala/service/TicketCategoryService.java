package com.Test.lala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.dto.TicketCategoryDTO;
import com.Test.lala.repository.TicketCategoryRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketCategoryService {

    private final TicketCategoryRepository ticketCategoryRepository;

    @Autowired
    public TicketCategoryService(TicketCategoryRepository ticketCategoryRepository) {
        this.ticketCategoryRepository = ticketCategoryRepository;
    }

    public List<TicketCategory> getFindAllTickets() {
        return ticketCategoryRepository.findAll();
    }

}
