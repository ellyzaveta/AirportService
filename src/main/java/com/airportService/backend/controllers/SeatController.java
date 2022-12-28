package com.airportService.backend.controllers;

import com.airportService.backend.models.Seat;
import com.airportService.backend.services.SeatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SeatController {
    @Autowired
    private final SeatServiceImpl seatService;

    public SeatController(SeatServiceImpl seatService) {
        this.seatService = seatService;
    }

    public List<Seat> findAll() {
        return seatService.findAll();
    }

    public void addSeat(Seat seat) {
        seatService.addSeat(seat);
    }
}
