package com.Test.lala.service;

import com.Test.lala.model.OrderU;
import com.Test.lala.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

   public List<OrderU> orderFindAll(){
        return orderRepository.findAll();
   }

   public OrderU createOrder(OrderU lala){
        return orderRepository.save(lala);
   }
}
