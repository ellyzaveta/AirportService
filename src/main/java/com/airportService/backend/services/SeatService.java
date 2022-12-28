package com.airportService.backend.services;

import com.airportService.backend.models.Seat;

import java.util.List;

public interface SeatService {
    public List<Seat> findAll();
    public void addSeat(Seat seat);
}
