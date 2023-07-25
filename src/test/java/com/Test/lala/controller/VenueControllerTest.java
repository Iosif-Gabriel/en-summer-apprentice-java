package com.Test.lala.controller;

import com.Test.lala.model.Venue;
import com.Test.lala.service.VenueService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VenueControllerTest {
    @Mock
    private VenueService venueService;

    @InjectMocks
    private VenueController venueController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllOrders() {

        List<Venue> mockVenues = new ArrayList<>();

        Venue venue1 = new Venue();
        venue1.setIdVenue(101L);
        venue1.setVenueType("Venue 1");
        mockVenues.add(venue1);

        when(venueService.orderFindAll()).thenReturn(mockVenues);

        List<Venue> result = venueController.getAllOrders();

        verify(venueService, times(1)).orderFindAll();


        assertEquals(mockVenues.size(), result.size());


    }

}