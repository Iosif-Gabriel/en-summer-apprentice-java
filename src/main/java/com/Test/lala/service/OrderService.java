package com.Test.lala.service;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.model.UserU;
import com.Test.lala.repository.OrderRepository;
import com.Test.lala.repository.TicketCategoryRepository;
import com.Test.lala.repository.UserRepository;
import com.Test.lala.model.dto.OrderDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.Test.lala.service.mapper.OrderDTOMapper.createOrderDTO;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private final UserRepository userRepository;

    private TicketCategoryRepository ticketCategoryRepository;

    private TicketCategoryService ticketCategoryService;
    @Autowired
    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository, TicketCategoryRepository ticketCategoryRepository,TicketCategoryService ticketCategoryService) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.ticketCategoryRepository=ticketCategoryRepository;
        this.ticketCategoryService=ticketCategoryService;

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

        orderRepository.save(order);
    }

    public OrderDTO createOrderDB(OrderDTO orderRequestDTO, Long idUser) {
        double totalPrice = ticketCategoryService.getTotalPrice(orderRequestDTO);

        OrderDTO orderDTO = createOrderDTO(orderRequestDTO, totalPrice);
        saveOrder(orderDTO, idUser);
        return orderDTO;
    }
}
