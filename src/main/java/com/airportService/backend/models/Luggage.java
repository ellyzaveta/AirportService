package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Luggage {
    @Id
    @GeneratedValue
    private Long id;
    private Double weight;
    @ManyToOne(cascade = CascadeType.MERGE)
    LuggageType luggageType;
}
