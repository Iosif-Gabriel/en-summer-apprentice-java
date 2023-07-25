package com.Test.lala.service;

import com.Test.lala.model.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.repository.TicketCategoryRepository;
import java.util.List;

import static com.Test.lala.service.mapper.OrderDTOMapper.createOrderDTO;

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

    public TicketCategory getTicketCategoryById(Long id){
        return ticketCategoryRepository.findByidTicketCategory(id);
    }

    public double getTotalPrice(OrderDTO orderRequestDTO) {
        TicketCategory ticketCategory = getTicketCategoryById(orderRequestDTO.getTicketCategoryID());
        double totalPrice = orderRequestDTO.getNumberOfTickets() * ticketCategory.getPrice();
        return totalPrice;
    }





}
