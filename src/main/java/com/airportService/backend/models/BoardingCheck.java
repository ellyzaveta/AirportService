package com.airportService.backend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BoardingCheck {
    @Id
    @GeneratedValue
    private Long id;
    private boolean checkResult;
    private String comments;
    @OneToOne(cascade = CascadeType.MERGE)
    private BoardingPass boardingPass;
}
