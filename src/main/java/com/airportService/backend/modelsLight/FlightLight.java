package com.airportService.backend.modelsLight;

import lombok.Data;

import java.util.Date;

@Data
public class FlightLight {
    private String flightNumber;
    private Date departure;
    private Date arrival;
    private String departureAirport;
    private String arrivalAirport;

    public FlightLight(String flightNumber, Date departure, Date arrival, String departureAirport, String arrivalAirport){
        this.flightNumber = flightNumber;
        this.arrival = arrival;
        this.departure = departure;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }
}

