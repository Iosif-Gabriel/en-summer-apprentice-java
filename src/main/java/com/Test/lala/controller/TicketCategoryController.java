package com.Test.lala.controller;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.mapper.OrderToOrderDToMapper;
import com.Test.lala.service.mapper.TicketToTickerDToMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Test.lala.service.TicketCategoryService;
import com.Test.lala.service.dto.TicketCategoryDTO;
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
        return ordersUser.stream().map(TicketToTickerDToMapper::req).collect(Collectors.toList());
    }
}

