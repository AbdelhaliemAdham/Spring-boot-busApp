package com.example.reservationApp.services.implementer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.reservationApp.entities.BusRoute;
import com.example.reservationApp.models.ApiExceptionError;
import com.example.reservationApp.repo.BusRouteRepository;
import com.example.reservationApp.services.BusRouteService;
@Service
public class BusRouteServiceImpl implements BusRouteService {
    @Autowired
    private BusRouteRepository bRouteRepository;

    @Override
    public BusRoute addBusRoute(BusRoute busRoute) {
        return bRouteRepository.save(busRoute);
    }

    @Override
    public List<BusRoute> getAllBusRoutes() {
       return bRouteRepository.findAll();
    }

    @Override
    public BusRoute getRouteByRouteName(String routeName) {
       return bRouteRepository.findByRouteName(routeName).orElseThrow(()->new ApiExceptionError(HttpStatus.BAD_REQUEST,"Can't find this route"));

    }

    @Override
    public BusRoute getRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return bRouteRepository.findByCityFromAndCityTo(cityFrom, cityTo).orElseThrow(()->new ApiExceptionError(HttpStatus.BAD_REQUEST,"Can't find this route"));
    }

    


}
