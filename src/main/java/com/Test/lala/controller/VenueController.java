package com.Test.lala.controller;

import com.Test.lala.model.OrderU;
import com.Test.lala.model.Venue;
import com.Test.lala.service.OrderService;
import com.Test.lala.service.VenueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class VenueController {

    private VenueService venueService;

    public VenueController(VenueService venueService){
        this.venueService=venueService;
    }

    @GetMapping("/ceva")
    public List<Venue> getAllOrders() {
        return venueService.orderFindAll();
    }
}
