package com.Test.lala.service;


import com.Test.lala.model.Venue;

import com.Test.lala.repository.VenueRepository;
import com.Test.lala.service.interfaceservice.IVenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueService implements IVenueService {

    private VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public List<Venue> orderFindAll(){
        return venueRepository.findAll();
    }
}
