package com.airportService.backend.repositories;

import com.airportService.backend.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Passenger findByPassportNumber(String passportNumber);
}
