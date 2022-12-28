package com.airportService.backend.services;

import com.airportService.backend.models.Aircraft;
import com.airportService.backend.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftServiceImpl implements AircraftService {
    @Autowired
    private final AircraftRepository aircraftRepository;

    public AircraftServiceImpl(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public void addAircraft(Aircraft aircraft) {
        aircraftRepository.save(aircraft);
    }

    @Override
    public Aircraft findAircraftById(Long id) {
        return aircraftRepository.findById(id).orElse(null);
    }
}

