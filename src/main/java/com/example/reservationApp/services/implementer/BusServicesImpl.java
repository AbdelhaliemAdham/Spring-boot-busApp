package com.example.reservationApp.services.implementer;

import com.example.reservationApp.entities.Bus;
import com.example.reservationApp.repo.BusRepository;
import com.example.reservationApp.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class BusServicesImpl implements BusService {
    @Autowired
    private BusRepository busRepository;
    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> addAllBus() {
        return  busRepository.findAll();
    }
}
