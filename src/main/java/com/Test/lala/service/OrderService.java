package com.Test.lala.service;

import com.Test.lala.model.EventU;
import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.model.UserU;
import com.Test.lala.repository.OrderRepository;
import com.Test.lala.repository.TicketCategoryRepository;
import com.Test.lala.repository.UserRepository;
import com.Test.lala.service.dto.OrderDTO;
import jakarta.persistence.EntityNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private final UserRepository userRepository;

    private TicketCategoryRepository ticketCategoryRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository, TicketCategoryRepository ticketCategoryRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.ticketCategoryRepository=ticketCategoryRepository;

    }

    public List<OrderU> orderFindAll() {
        return orderRepository.findAll();
    }

    public OrderU createOrder(OrderU lala) {
        return orderRepository.save(lala);
    }

    public OrderU findById(Long id) {
        Optional<OrderU> orderFindById = orderRepository.findById(id);
        if (orderFindById.isPresent()) {
            return orderFindById.get();
        } else {
            throw new EntityNotFoundException("Event not found " + orderFindById);
        }
    }
    public List<OrderU> findCustomerOrders(Long userId) {
        return orderRepository.findByUser_IdUser(userId);
    }

    public void saveOrder(OrderDTO orderDTO,Long idUser) {
        OrderU order = new OrderU();

        TicketCategory ticketCategoryOrdered=ticketCategoryRepository.
                findByidTicketCategory(orderDTO.getTicketCategoryID());


        UserU user=userRepository.findUserUByIdUser(idUser);
        order.setUser(user);
        order.setTicketCategory(ticketCategoryOrdered);
        order.setOrderedAt(orderDTO.getOrderedAt());
        order.setNumberOfTickets(orderDTO.getNumberOfTickets());
        order.setTotalPrice((int) orderDTO.getTotalPrice());
        System.out.println(order);

        orderRepository.save(order);
    }
}
