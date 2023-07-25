package com.Test.lala.controller;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.TicketCategory;
import com.Test.lala.service.OrderService;
import com.Test.lala.service.TicketCategoryService;
import com.Test.lala.model.dto.OrderDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Mock
    private TicketCategoryService ticketCategoryService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void testGetCustomerOrders() {

        Long userId = 1L;
        List<OrderU> mockOrders = new ArrayList<>();

        when(orderService.findCustomerOrders(userId)).thenReturn(mockOrders);
        List<OrderDTO> result = orderController.getCustomerOrders(userId);
        verify(orderService, times(1)).findCustomerOrders(userId);

        Assertions.assertEquals(mockOrders.size(), result.size());

    }

    @Test
    public void testCreateOrder() throws Exception {

        Long idUser = 1L;
        Long idEvent = 100L;
        Long ticketCategoryId = 200L;
        int numberOfTickets = 3;
        double ticketPrice = 50.0;


        TicketCategory mockTicketCategory = new TicketCategory();
        mockTicketCategory.setIdTicketCategory(ticketCategoryId);
        mockTicketCategory.setPrice(ticketPrice);
        when(ticketCategoryService.getTicketCategoryById(ticketCategoryId)).thenReturn(mockTicketCategory);


        String requestBody = "{" +
                "\"idEvent\": " + idEvent + "," +
                "\"ticketCategoryID\": " + ticketCategoryId + "," +
                "\"numberOfTickets\": " + numberOfTickets +
                "}";


        mockMvc.perform(post("/createOrder/{idUser}", idUser)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.idEvent").value(idEvent))
                .andExpect(jsonPath("$.ticketCategoryID").value(ticketCategoryId))
                .andExpect(jsonPath("$.numberOfTickets").value(numberOfTickets))
                .andExpect(jsonPath("$.totalPrice").value(numberOfTickets * ticketPrice));


        verify(orderService, times(1)).saveOrder(any(OrderDTO.class), eq(idUser));


    }



}