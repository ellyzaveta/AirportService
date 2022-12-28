package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SeatPlace {
    @Id
    @GeneratedValue
    private Long id;
    private Boolean isReserved = false;
    private String seatNumber;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Flight flight;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Seat seat;

    public String toString() {
        return String.format("%s", seatNumber);
    }
}
