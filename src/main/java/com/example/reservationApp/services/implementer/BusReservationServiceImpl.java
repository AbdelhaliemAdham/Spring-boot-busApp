package com.example.reservationApp.services.implementer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.reservationApp.entities.BusSchedule;
import com.example.reservationApp.entities.Customer;
import com.example.reservationApp.entities.Reservation;
import com.example.reservationApp.models.ApiExceptionError;
import com.example.reservationApp.repo.BusReservationRepository;
import com.example.reservationApp.repo.BusScheduleRepository;
import com.example.reservationApp.repo.CustomerRepository;
import com.example.reservationApp.services.BusReservationService;

@Service
public class BusReservationServiceImpl implements BusReservationService {
    @Autowired
    private BusReservationRepository repository;
    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private CustomerRepository customerRepository; 
    @Override
    public Reservation addReservation(Reservation reservation) {
       return repository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return repository.findAll();
    }

    @Override
    public List<Reservation> getReservationsByBusScheduleIdAndDepartureTime(Long scheduleId, String departureTime) {
   final BusSchedule busSchedule= busScheduleRepository.findById(scheduleId).
    orElseThrow(()->new ApiExceptionError(HttpStatus.NOT_FOUND, " schedule Not Found") );
   return repository.findByBusScheduleAndDepartureDate(busSchedule, departureTime).
    orElseThrow(()->new ApiExceptionError(HttpStatus.NOT_FOUND, " schedule Not Found") );
     

    }

    @Override
    public List<Reservation> getRerservationByMobile(String mobile) {
       final Customer customer= customerRepository.findByMobile(mobile).
    orElseThrow(()->new ApiExceptionError(HttpStatus.NOT_FOUND, " customer Not Found") );
    return repository.findByCustomer(customer).
    orElseThrow(()->new ApiExceptionError(HttpStatus.NOT_FOUND, " customer Not Found") );


    }
    

}
