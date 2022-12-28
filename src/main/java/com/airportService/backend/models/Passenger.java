package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String passportNumber;
    private LocalDate birthDate;
    private String countryOfCitizenship;
    private String countryOfResidents;

    public String toString() {
        return String.format(" %s", passportNumber);
    }
}