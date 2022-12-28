package com.airportService.backend.controllers;

import com.airportService.backend.models.SeatPlace;
import com.airportService.backend.services.SeatPlaceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SeatPlaceController {
    @Autowired
    private final SeatPlaceServiceImpl seatService;

    public SeatPlaceController(SeatPlaceServiceImpl seatService) {
        this.seatService = seatService;
    }

    public void addSeatPlace(SeatPlace seatPlace){
        seatService.addSeatPlace(seatPlace);
    }

    public List<SeatPlace> getUnreservedSeatsByFlightId(Long id) {
        return seatService.getUnreservedSeatsByFlightId(id);
    }

    public void setSeatToReserved(Long id) {
        seatService.setSeatToReserved(id);
    }

    public void setSeatToUnReserved(Long id) {
        seatService.setSeatToUnReserved(id);
    }
}
