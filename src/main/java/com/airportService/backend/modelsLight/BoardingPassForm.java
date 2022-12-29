package com.airportService.backend.modelsLight;

import lombok.Data;

import java.util.Date;

@Data
public class BoardingPassForm {
    private String firstName;
    private String lastName;
    private String flightNumber;
    private Date depTime;
    private String seat;
    private String arrAirport;
    private String qrCode;
    public BoardingPassForm(String firstName, String lastName, String flightNumber, Date depTime,
                            String seat, String arrAirport, String qrCode){
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightNumber = flightNumber;
        this.depTime = depTime;
        this.seat = seat;
        this.arrAirport = arrAirport;
        this.qrCode = qrCode;
    }
}