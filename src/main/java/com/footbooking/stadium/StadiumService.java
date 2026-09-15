package com.footbooking.stadium;

import com.footbooking.common.exception.ResourceNotFoundException;

public class StadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumService(StadiumRepository stadiumRepository){
        this.stadiumRepository = stadiumRepository;
    }

    public Stadium getById(Long id){
        return stadiumRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stadium not found with id: " + id));
    }
}
