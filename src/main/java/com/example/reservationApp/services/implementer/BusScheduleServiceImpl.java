package com.example.reservationApp.services.implementer;

import com.example.reservationApp.entities.BusRoute;
import com.example.reservationApp.entities.BusSchedule;
import com.example.reservationApp.models.ApiExceptionError;
import com.example.reservationApp.repo.BusRouteRepository;
import com.example.reservationApp.repo.BusScheduleRepository;
import com.example.reservationApp.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService{

    @Autowired
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private BusRouteRepository bRouteRepository;

    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) {
        boolean exist = busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(busSchedule.getBus(), busSchedule.getBusRoute(),
                busSchedule.getDepartureTime());
       if(exist){
        throw new ApiExceptionError(HttpStatus.CONFLICT,"This Schedule is already exist");
       }
        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getAllSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getScheduleByRouteName(String routeName) {
    final BusRoute rBusRoute = bRouteRepository.findByRouteName(routeName).orElseThrow(()-> new ApiExceptionError(HttpStatus.BAD_REQUEST,"Can't find this schedule"));
        return busScheduleRepository.findByBusRoute(rBusRoute).orElseThrow(()-> new ApiExceptionError(HttpStatus.BAD_REQUEST,"Can't find this schedule"));
    }
}
