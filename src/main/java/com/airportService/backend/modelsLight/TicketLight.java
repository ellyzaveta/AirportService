package com.airportService.backend.modelsLight;

import lombok.Data;

@Data
public class TicketLight {
    private String flightNumber;
    private String passportNumber;
    private String seat;
    private String ticketNumber;

    public TicketLight(String flightNumber, String passportNumber, String seat, String ticketNumber) {
        this.flightNumber = flightNumber;
        this.passportNumber = passportNumber;
        this.seat = seat;
        this.ticketNumber = ticketNumber;
    }
}
