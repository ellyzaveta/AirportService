package com.airportService.backend.controllers;

import com.airportService.backend.models.Passenger;
import com.airportService.backend.services.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private final PassengerServiceImpl passengerServiceImpl;

    public PassengerController(PassengerServiceImpl passengerServiceImpl) {
        this.passengerServiceImpl = passengerServiceImpl;
    }

    public void addPassenger(Passenger passenger) {
        passengerServiceImpl.addPassenger(passenger);
    }

    public Passenger findById(Long id) {
        return passengerServiceImpl.findById(id);
    }

    public List<Passenger> findAll(){
        return passengerServiceImpl.findAll();
    }

    public void delete(Passenger passenger) {
        passengerServiceImpl.delete(passenger);
    }

    public Passenger findByPassportNumber(String passportNumber) {
        return passengerServiceImpl.findByPassportNumber(passportNumber);
    }
}
