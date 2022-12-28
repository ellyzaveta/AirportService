package com.airportService.backend.repositories;

import com.airportService.backend.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}

