package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SecurityControl {
    @Id
    @GeneratedValue
    private Long id;
    private boolean checkResult;
    private String comments;
    @OneToOne(cascade = CascadeType.MERGE)
    private Passenger passenger;
}
