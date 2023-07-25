package com.Test.lala.controller;

import com.Test.lala.model.EventU;
import com.Test.lala.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EventController.class)
class EventControllerTest {
    @MockBean
    private EventService eventService;

    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private EventController eventController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(eventController).build();
    }


    @Test
    public void testGetEventVenueType() throws Exception {

        Long venueId = 1L;
        String eventType = "Cooking";
        List<EventU> mockEvents = new ArrayList<>();


        when(eventService.getEventsByVenueIdAndEventType(venueId, eventType)).thenReturn(mockEvents);

        mockMvc.perform(get("/events")
                        .param("idVenue", venueId.toString())
                        .param("eventTypeName", eventType))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(mockEvents.size()));


    }
}