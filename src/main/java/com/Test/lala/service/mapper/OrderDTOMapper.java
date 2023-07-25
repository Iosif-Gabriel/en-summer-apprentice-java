package com.Test.lala.service.mapper;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.dto.OrderDTO;

import java.util.Date;

public class OrderDTOMapper {
    public static OrderDTO converter(OrderU order) {
        OrderDTO orderResponseDTO = new OrderDTO();
        orderResponseDTO.setOrderedAt(order.getOrderedAt());
        //orderResponseDTO.setTicketCategoryId(String.valueOf(order.getTicketCategory().getIdTicketCategory()));
        orderResponseDTO.setNumberOfTickets(order.getNumberOfTickets());
        orderResponseDTO.setTotalPrice(order.getTotalPrice());

        if (order.getTicketCategory() != null && order.getTicketCategory().getEvent() != null) {
            orderResponseDTO.setIdEvent(order.getTicketCategory().getEvent().getIdEvent());
            orderResponseDTO.setTicketCategoryID(order.getTicketCategory().getIdTicketCategory());
        }
        return orderResponseDTO;
    }

    public static OrderDTO createOrderDTO(OrderDTO orderRequestDTO, double totalPrice) {
        Date orderedAt = new Date();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setIdEvent(orderRequestDTO.getIdEvent());
        orderDTO.setTicketCategoryID(orderRequestDTO.getTicketCategoryID());
        orderDTO.setOrderedAt(orderedAt);
        orderDTO.setNumberOfTickets(orderRequestDTO.getNumberOfTickets());
        orderDTO.setTotalPrice(totalPrice);
        return orderDTO;
    }




}
