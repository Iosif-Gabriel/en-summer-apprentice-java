package com.Test.lala.service.mapper;

import com.Test.lala.model.OrderU;
import com.Test.lala.service.dto.OrderDTO;
import com.Test.lala.service.dto.TicketCategoryDTO;

public class OrderToOrderDToMapper {
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


}
