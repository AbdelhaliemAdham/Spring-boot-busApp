package com.example.reservationApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservationApp.entities.BusRoute;
import com.example.reservationApp.models.ResponseModel;
import com.example.reservationApp.services.BusRouteService;


@RestController
@RequestMapping("/api/busRoute")
public class BusRouteController {
    @Autowired
    private BusRouteService bRouteSerivce;

    @PostMapping("/add")
    public ResponseModel<BusRoute> addBusRoute(@RequestBody BusRoute busRoute) {
      final  BusRoute nBusRoute = bRouteSerivce.addBusRoute(busRoute);
        return new ResponseModel<BusRoute>(HttpStatus.OK.value(),"BusRouteAdded",nBusRoute);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<BusRoute>> getAllBusRoutes() {
        return  ResponseEntity.ok(bRouteSerivce.getAllBusRoutes());
    }
    @GetMapping("/{routeName}")
    public ResponseEntity<BusRoute> getRouteByRouteName(@PathVariable(name = "routeName") String routeName){
        return  ResponseEntity.ok(bRouteSerivce.getRouteByRouteName(routeName)); 
    }

    @GetMapping("/query")
    public ResponseEntity<BusRoute> getRouteByCityFromAndCityToo(@RequestParam String cityFrom,@RequestParam String cityTo){
        return ResponseEntity.ok(bRouteSerivce.getRouteByCityFromAndCityTo(cityFrom, cityTo));
    }
}