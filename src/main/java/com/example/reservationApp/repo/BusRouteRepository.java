package com.example.reservationApp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reservationApp.entities.BusRoute;

public interface BusRouteRepository extends JpaRepository<BusRoute,Long> {

     Optional<BusRoute> findByRouteName(String routeName);
     Optional<BusRoute> findByCityFromAndCityTo(String cityFrom,String cityTo);
    
}
