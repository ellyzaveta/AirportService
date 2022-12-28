package com.airportService.backend.controllers;

import com.airportService.backend.models.Aircraft;
import com.airportService.backend.services.AircraftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AircraftController {
    @Autowired
    private final AircraftServiceImpl aircraftService;

    public AircraftController(AircraftServiceImpl aircraftService) {
        this.aircraftService = aircraftService;
    }

    public void addAircraft(Aircraft aircraft) {
        aircraftService.addAircraft(aircraft);
    }

    public Aircraft findAircraftById(Long id) {
        return aircraftService.findAircraftById(id);
    }
}
