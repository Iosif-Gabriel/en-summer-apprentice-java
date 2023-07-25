package com.Test.lala.controller;

import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.mapper.TicketDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Test.lala.service.TicketCategoryService;
import com.Test.lala.model.dto.TicketCategoryDTO;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TicketCategoryController {

    private final TicketCategoryService ticketCategoryService;

    @Autowired
    public TicketCategoryController(TicketCategoryService ticketCategoryService) {
        this.ticketCategoryService = ticketCategoryService;
    }

    @GetMapping("/ticket-categories")
    public List<TicketCategoryDTO> getAllTicketCategories() {
        List<TicketCategory> ordersUser=ticketCategoryService.getFindAllTickets();
        return ordersUser.stream().map(TicketDTOMapper::req).collect(Collectors.toList());
    }
}

