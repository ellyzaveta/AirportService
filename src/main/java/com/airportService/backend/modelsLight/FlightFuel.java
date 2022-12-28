package com.airportService.backend.modelsLight;

import lombok.Data;

@Data
public class FlightFuel {
    private String flightNumber;
    private String aircraftModel;
    private Long totalTime;
    private Double fuelPerHour;
    private Double fuelForFlight;
    public FlightFuel(String flightNumber, String aircraftModel, Long totalTime, Double fuelPerHour) {
        this.flightNumber = flightNumber;
        this.totalTime = totalTime;
        this.aircraftModel = aircraftModel;
        this.fuelPerHour = fuelPerHour;
        this.fuelForFlight = fuelPerHour * totalTime;
    }
}
