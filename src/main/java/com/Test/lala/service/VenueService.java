package com.Test.lala.service;



import com.Test.lala.model.OrderU;
import com.Test.lala.model.Venue;
import com.Test.lala.repository.OrderRepository;
import com.Test.lala.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VenueService {

    private VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> orderFindAll(){
        return venueRepository.findAll();
    }
}
