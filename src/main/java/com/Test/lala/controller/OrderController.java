package com.Test.lala.controller;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.OrderService;
import com.Test.lala.service.TicketCategoryService;
import com.Test.lala.model.dto.OrderDTO;
import com.Test.lala.service.mapper.OrderDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.Test.lala.service.mapper.OrderDTOMapper.createOrderDTO;

@RestController
public class OrderController {

    private OrderService orderService;
    private TicketCategoryService ticketCategoryService;

    @Autowired
    public OrderController(OrderService orderService, TicketCategoryService ticketCategoryService) {
        this.orderService = orderService;
        this.ticketCategoryService=ticketCategoryService;
    }

    @GetMapping("/allOrders")
    public List<OrderDTO> getAllOrders() {
        List<OrderU> orders=orderService.orderFindAll();
        List<OrderDTO> orderDTOS= new ArrayList<>();

        for(OrderU order:orders){
            orderDTOS.add(OrderDTOMapper.converter(order));
        }

        return orderDTOS;
    }


    @GetMapping("/customer-orders/{userId}")
    public List<OrderDTO> getCustomerOrders(@PathVariable Long userId) {
        List<OrderU> ordersUser=orderService.findCustomerOrders(userId);
        return ordersUser.stream().map(OrderDTOMapper::converter).collect(Collectors.toList());
    }

    @PostMapping("/createOrder/{idUser}")
    public OrderDTO createOrder(@RequestBody OrderDTO orderRequestDTO,@PathVariable Long idUser ) {

        return orderService.createOrderDB(orderRequestDTO, idUser);
    }






}

