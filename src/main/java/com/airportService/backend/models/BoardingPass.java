package com.airportService.backend.models;

import com.airportService.backend.rand.Rand;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BoardingPass {
    @Id
    @GeneratedValue
    private Long id;
    private String qrCode = Rand.generateQRCode();
    private boolean isChecked;
    @OneToOne(cascade = CascadeType.MERGE)
    private Ticket ticket;
    @OneToOne(cascade = CascadeType.MERGE)
    private Luggage luggage;
    public String toString() {
        return String.format("%s", qrCode);
    }
}