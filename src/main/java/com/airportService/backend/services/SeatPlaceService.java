package com.airportService.backend.services;

import com.airportService.backend.models.SeatPlace;

import java.util.List;

public interface SeatPlaceService {
    void addSeatPlace(SeatPlace seatPlace);
    List<SeatPlace> getUnreservedSeatsByFlightId(Long id);
    void setSeatToReserved(Long id);
    void setSeatToUnReserved(Long id);
}
