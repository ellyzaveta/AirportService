package com.airportService.backend.controllers;

import com.airportService.backend.models.Passenger;
import com.airportService.backend.models.PassportControl;
import com.airportService.backend.models.SecurityControl;
import com.airportService.backend.services.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private final PassengerServiceImpl passengerServiceImpl;
    @Autowired
    private final SecurityControlController securityControlController;
    @Autowired
    private final PassportControlController passportControlController;

    public PassengerController(PassengerServiceImpl passengerServiceImpl, SecurityControlController securityControlController, PassportControlController passportControlController) {
        this.passengerServiceImpl = passengerServiceImpl;
        this.securityControlController = securityControlController;
        this.passportControlController = passportControlController;
    }

    public void addPassenger(Passenger passenger) {
        passengerServiceImpl.addPassenger(passenger);
        SecurityControl securityControl = new SecurityControl();
        securityControl.setPassenger(passenger);
        securityControlController.addRecord(securityControl);
        PassportControl passportControl = new PassportControl();
        passportControl.setPassenger(passenger);
        passportControlController.addRecord(passportControl);
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
