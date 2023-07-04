package com.example.reservationApp.controllers;

import com.example.reservationApp.entities.Bus;
import com.example.reservationApp.models.ResponseModel;
import com.example.reservationApp.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping("/add")
    public ResponseModel<Bus> addBus(@RequestBody Bus bus){
       Bus savedBus= busService.addBus(bus);
        return new ResponseModel<Bus>(HttpStatus.OK.value(), "Bus added",savedBus);
    }

    @GetMapping("/All")
    public ResponseEntity<List<Bus>> getAllBus(){
     return   ResponseEntity.ok(busService.addAllBus());
    }
}
