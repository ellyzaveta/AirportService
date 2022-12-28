package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Seat {
    @Id
    @GeneratedValue
    private Long id;
    private String seatNumber;
    private String seatClass;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Aircraft aircraft;
}
