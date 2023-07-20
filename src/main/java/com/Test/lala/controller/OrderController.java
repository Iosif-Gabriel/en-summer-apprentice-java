package com.Test.lala.controller;

import com.Test.lala.model.OrderU;
import com.Test.lala.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<OrderU> getAllOrders() {
        return orderService.orderFindAll();
    }

    @PostMapping("/createOrder")
    public OrderU createOrderU(@RequestBody OrderU orderU) {
        return orderService.createOrder(orderU);
    }


}

