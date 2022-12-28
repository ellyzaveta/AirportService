package com.airportService.backend.services;

import com.airportService.backend.models.Passenger;
import com.airportService.backend.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private final PassengerRepository passengerRepository;

    public PassengerServiceImpl(PassengerRepository passengerRepository){
        this.passengerRepository = passengerRepository;
    }

    public void addPassenger(Passenger passenger) {
        passengerRepository.save(passenger);
    }

    public Passenger findById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public List<Passenger> findAll() {
        return passengerRepository.findAll();
    }

    public void delete(Passenger passenger) {
        passengerRepository.delete(passenger);
    }

    @Override
    public Passenger findByPassportNumber(String passportNumber) {
        return passengerRepository.findByPassportNumber(passportNumber);
    }
}
