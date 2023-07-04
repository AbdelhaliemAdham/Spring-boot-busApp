package com.example.reservationApp.services;

import com.example.reservationApp.entities.BusSchedule;

import java.util.List;


public interface BusScheduleService {

    BusSchedule addSchedule(BusSchedule busSchedule);
    
    List<BusSchedule> getAllSchedules();

    List<BusSchedule> getScheduleByRouteName(String routeName);
}
