package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Aircraft {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Double fuelPerHour;
    @Column
    private String model;
    @Column
    private Integer totalNumOfPlaces;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Seat> seats;

    public String toString() {
        return String.format(" %s", model);
    }
}
