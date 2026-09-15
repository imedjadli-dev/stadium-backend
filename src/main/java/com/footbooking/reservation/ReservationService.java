package com.footbooking.reservation;

import com.footbooking.common.exception.ResourceNotFoundException;

public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }


    public Reservation getById(Long id){
        return reservationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Reservation not found with id" + id));
    }
}