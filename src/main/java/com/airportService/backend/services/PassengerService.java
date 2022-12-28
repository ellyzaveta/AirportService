package com.airportService.backend.services;

import com.airportService.backend.models.Passenger;

import java.util.List;

public interface PassengerService {
    public void addPassenger(Passenger passenger);
    public Passenger findById(Long id);
    public List<Passenger> findAll();
    public void delete(Passenger passenger);
    Passenger findByPassportNumber(String passportNumber);
}
