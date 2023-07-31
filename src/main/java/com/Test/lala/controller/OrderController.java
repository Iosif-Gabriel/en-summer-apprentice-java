package com.Test.lala.controller;


import com.Test.lala.exception.OrderException;
import com.Test.lala.exception.UserException;
import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.OrderService;
import com.Test.lala.service.TicketCategoryService;
import com.Test.lala.model.dto.OrderDTO;
import com.Test.lala.service.mapper.OrderDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
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

    @GetMapping("/allOrders")
    public List<OrderDTO> getAllOrders() {
        try {
            List<OrderU> orders = orderService.orderFindAll();
            List<OrderDTO> orderDTOS = new ArrayList<>();

            for (OrderU order : orders) {
                orderDTOS.add(OrderDTOMapper.converter(order));
            }

            return orderDTOS;
        } catch (Exception e) {

            throw new OrderException("Failed to fetch all orders", e);
        }
    }


    @GetMapping("/customer-orders/{userId}")
    public List<OrderDTO> getCustomerOrders(@PathVariable Long userId) {
        try {
            List<OrderU> ordersUser = orderService.findCustomerOrders(userId);
            return ordersUser.stream().map(OrderDTOMapper::converter).collect(Collectors.toList());
        } catch (UserException e) {

            throw new OrderException("Customer orders not found: User with ID " + userId + " not found", e);
        } catch (Exception e) {

            throw new OrderException("Failed to fetch customer orders", e);
        }
    }

    @PostMapping("/createOrder/{idUser}")
    public OrderDTO createOrder(@RequestBody OrderDTO orderRequestDTO,@PathVariable Long idUser ) {
        try {
            return orderService.createOrderDB(orderRequestDTO, idUser);
        }catch (OrderException e){
            throw  new OrderException("Failed to create Ticket not found");
        }
    }

    @PatchMapping("/update-order/{orderId}")
    public void updateOrder(@RequestBody OrderDTO orderRequestDTO, @PathVariable Long orderId) {
        try {
            orderService.updateOrder(orderRequestDTO, orderId);
        } catch (OrderException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found", e);
        }
    }

    @DeleteMapping("/delete-order/{orderId}")
    public void deleteOrder(@PathVariable Long orderId) {
        try {
            orderService.deleteOrderById(orderId);
        } catch (OrderException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found", e);
        }
    }



}

