package com.Test.lala.controller;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.OrderService;
import com.Test.lala.service.TicketCategoryService;
import com.Test.lala.service.dto.OrderDTO;
import com.Test.lala.service.mapper.OrderToOrderDToMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    private OrderService orderService;
    private TicketCategoryService ticketCategoryService;

    @Autowired
    public OrderController(OrderService orderService, TicketCategoryService ticketCategoryService) {
        this.orderService = orderService;
        this.ticketCategoryService=ticketCategoryService;
    }

    @GetMapping("/orders2")
    public List<OrderU> getAllOrders() {
        return orderService.orderFindAll();
    }

    @PostMapping("/createOrder")
    public OrderU createOrderU(@RequestBody OrderU orderU) {
        return orderService.createOrder(orderU);
    }

    @GetMapping("/customer-orders/{userId}")
    public List<OrderDTO> getCustomerOrders(@PathVariable Long userId) {
        List<OrderU> ordersUser=orderService.findCustomerOrders(userId);
        return ordersUser.stream().map(OrderToOrderDToMapper::converter).collect(Collectors.toList());
    }

    @PostMapping("/orders/{idUser}")
    public OrderDTO createOrder(@RequestBody OrderDTO orderRequestDTO,@PathVariable Long idUser ) {

        TicketCategory ticketCategory = ticketCategoryService.getTicketCategoryById(orderRequestDTO.getTicketCategoryID());
        double totalPrice = orderRequestDTO.getNumberOfTickets() * ticketCategory.getPrice();

        Date orderedAt = new Date();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setIdEvent(orderRequestDTO.getIdEvent());
        orderDTO.setTicketCategoryID(orderRequestDTO.getTicketCategoryID());
        orderDTO.setOrderedAt(orderedAt);
        orderDTO.setNumberOfTickets(orderRequestDTO.getNumberOfTickets());
        orderDTO.setTotalPrice(totalPrice);
        orderService.saveOrder(orderDTO,idUser);

        return orderDTO;
    }


}

