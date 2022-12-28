package com.airportService.backend.modelsLight;

import lombok.Data;

@Data
public class TicketWidget {
    private String flightNumber;
    private String depAirport;
    private String arrAirport;
    private Integer numOfTickets;

    public TicketWidget(String flightNumber, String depAirport, String arrAirport, Integer numOfTickets) {
        this.flightNumber = flightNumber;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.numOfTickets = numOfTickets;
    }
}

