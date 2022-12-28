package com.airportService.backend.services;

import com.airportService.backend.models.Aircraft;

public interface AircraftService {
    void addAircraft(Aircraft aircraft);
    Aircraft findAircraftById(Long id);
}
