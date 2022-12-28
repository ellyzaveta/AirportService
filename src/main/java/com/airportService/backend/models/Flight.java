package com.airportService.backend.models;

import com.airportService.backend.rand.Rand;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Data
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Long id;
    private String flightNumber = Rand.generateFlightNumber();
    private Date departureTime;
    private Date arrivalTime;
    private Long totalTime = 0L;
    private Double price;
    private String depAirport;
    private String arrAirport;
    private Integer numOfAvailablePlaces;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Aircraft aircraft;

    public String toString() {
        return String.format(" %s", flightNumber);
    }
}
