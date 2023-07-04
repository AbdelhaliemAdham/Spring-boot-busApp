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
import org.springframework.web.bind.annotation.RestController;

import com.example.reservationApp.entities.BusSchedule;
import com.example.reservationApp.models.ResponseModel;
import com.example.reservationApp.services.BusScheduleService;

@RestController
@RequestMapping("api/schedule")
public class BusScheduleContoller {
    @Autowired
    private BusScheduleService bService;

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addSchedule(@RequestBody BusSchedule busSchedule){
     final BusSchedule bSchedule  =  bService.addSchedule(busSchedule);
        return new ResponseModel<>(HttpStatus.OK.value(),"Schedule add Sucessfully",bSchedule);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getAllSchedule(){
        
        return ResponseEntity.ok(bService.getAllSchedules());
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<List<BusSchedule>> getScheduleByRouteName(@PathVariable(name = "routeName") String routeName){
        return ResponseEntity.ok(bService.getScheduleByRouteName(routeName));
    }

}
