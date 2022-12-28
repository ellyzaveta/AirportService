package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Airport {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String country;
    @Column
    private String terminal;

    public String toString() {
        return String.format(" %s", name);
    }
}
