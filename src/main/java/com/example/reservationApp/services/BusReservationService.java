package com.example.reservationApp.services;

import java.util.List;

import com.example.reservationApp.entities.Reservation;

public interface BusReservationService {
    
    Reservation addReservation(Reservation reservation);

    List<Reservation> getAllReservation();

    List<Reservation> getReservationsByBusScheduleIdAndDepartureTime(
        Long scheduleId,
        String departureTime
    );
    List<Reservation> getRerservationByMobile(
        String mobile
    );


}
