package com.airportService.backend.modelsLight;

import lombok.Data;

import java.util.Date;

@Data
public class TimeWidget {
    private String flightNumber;
    private String arrAirport;
    private Date depTime;

    public TimeWidget(String flightNumber, String arrAirport, Date depTime) {
        this.flightNumber = flightNumber;
        this.arrAirport = arrAirport;
        this.depTime = depTime;
    }
}

