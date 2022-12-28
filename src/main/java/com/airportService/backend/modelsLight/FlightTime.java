package com.airportService.backend.modelsLight;

import lombok.Data;

import java.util.Date;

@Data
public class FlightTime {
    private String flightNumber;
    private Date departure;
    private Date arrival;
    private String departureAirport;
    private String arrivalAirport;
    private Integer ticketNum;

    public FlightTime(String flightNumber, Date departure, Date arrival, String departureAirport, String arrivalAirport, Integer ticketNum){
        this.flightNumber = flightNumber;
        this.arrival = arrival;
        this.departure = departure;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
        this.ticketNum = ticketNum;
    }
}
