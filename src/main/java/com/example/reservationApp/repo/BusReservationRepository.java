package com.example.reservationApp.repo;

import com.example.reservationApp.entities.BusSchedule;
import com.example.reservationApp.entities.Customer;
import com.example.reservationApp.entities.Reservation;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BusReservationRepository extends JpaRepository<Reservation,Long>{
    Optional<List<Reservation>> findByCustomer(Customer customer);
    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule,String departureTime);
    
}
