package com.Test.lala.service;

import com.Test.lala.exception.OrderException;
import com.Test.lala.exception.TicketException;
import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.model.UserU;
import com.Test.lala.repository.OrderRepository;
import com.Test.lala.repository.TicketCategoryRepository;
import com.Test.lala.repository.UserRepository;
import com.Test.lala.model.dto.OrderDTO;
import com.Test.lala.service.interfaceservice.IOrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.Test.lala.service.mapper.OrderDTOMapper.createOrderFromDTO;

@Service
public class OrderService implements IOrderService {

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
        //order.setTotalPrice((int) orderDTO.getTotalPrice());

        orderRepository.save(order);
    }

    public OrderDTO createOrderDB(OrderDTO orderRequestDTO, Long idUser) {
        try {
            double totalPrice = ticketCategoryService.getTotalPrice(orderRequestDTO);

            OrderDTO orderDTO = createOrderFromDTO(orderRequestDTO, totalPrice);
            saveOrder(orderDTO, idUser);

            return orderDTO;
        } catch (TicketException e) {

            throw new OrderException("Failed to create order: Ticket category not found");
        } catch (Exception e) {

            throw new OrderException("Failed to create order", e);
        }
    }

    public void updateOrder(OrderDTO orderRequestDTO, Long orderId) {

        Objects.requireNonNull(orderRequestDTO, "OrderDTO must not be null");

        double totalPrice = ticketCategoryService.getTotalPrice(orderRequestDTO);
        TicketCategory ticketCategory = ticketCategoryRepository.getReferenceById(orderRequestDTO.getTicketCategoryID());

        OrderU orderU = findById(orderId);
        if (orderU == null) {
            throw new OrderException("Order with ID " + orderId + " not found");
        }

        orderU.setTicketCategory(ticketCategory);
        orderU.setTotalPrice((int) totalPrice);
        orderU.setNumberOfTickets(orderRequestDTO.getNumberOfTickets());
        orderRepository.save(orderU);
    }

    public void deleteOrderById(Long orderId){
        OrderU orderU = findById(orderId);
        if (orderU == null) {
            throw new OrderException("Order with ID " + orderId + " not found");
        }
        orderRepository.delete(orderU);
    }

}
