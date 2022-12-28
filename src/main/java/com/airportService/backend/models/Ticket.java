package com.airportService.backend.models;

import com.airportService.backend.rand.Rand;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private Date buyingDate = new Date();
    private String uniqueNumber = Rand.generateTicketNumber();
    private Boolean hasBoardingPass = false;
    @ManyToOne(cascade = CascadeType.MERGE)
    Passenger passenger;
    @ManyToOne(cascade = CascadeType.MERGE)
    Flight flight;
    @OneToOne(cascade = CascadeType.MERGE)
    SeatPlace seatPlace;
}
