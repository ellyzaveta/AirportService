package com.airportService.backend.modelsLight;

import lombok.Data;

import java.util.Date;

@Data
public class TicketForm {
    private String firstName;
    private String lastName;
    private String ticketNumber;
    private String flightNumber;
    private Date depTime;
    private String arrAirport;
    private String seat;
    private Date buyingDate;
    private Double price;

    public TicketForm(String firstName, String lastName, String flightNumber, Date depTime,
                      String arrAirport, String seat, Date buyingDate, Double price, String ticketNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNumber = flightNumber;
        this.depTime = depTime;
        this.arrAirport = arrAirport;
        this.buyingDate = buyingDate;
        this.seat = seat;
        this.price = price;
        this.ticketNumber = ticketNumber;
    }
}

