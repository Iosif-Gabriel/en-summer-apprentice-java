package com.Test.lala.service.interfaceservice;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    List<OrderU> orderFindAll();

    OrderU findById(Long id);

    List<OrderU> findCustomerOrders(Long userId);

    void saveOrder(OrderDTO orderDTO, Long idUser);

    OrderDTO createOrderDB(OrderDTO orderRequestDTO, Long idUser);

    void updateOrder(OrderDTO reqDto,Long id);

    void deleteOrderById(Long id);
}
