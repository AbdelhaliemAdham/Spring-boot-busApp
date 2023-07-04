package com.example.reservationApp.services;

import java.util.List;

import com.example.reservationApp.entities.BusRoute;

public interface BusRouteService {

  BusRoute  addBusRoute(BusRoute busRoute);

  List<BusRoute> getAllBusRoutes();

  BusRoute getRouteByRouteName(String routeName);

  BusRoute getRouteByCityFromAndCityTo(String cityFrom,String cityTo);


}
