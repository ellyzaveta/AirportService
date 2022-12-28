package com.airportService.backend.services;

import com.airportService.backend.models.SeatPlace;
import com.airportService.backend.repositories.SeatPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatPlaceServiceImpl implements SeatPlaceService {
    @Autowired
    private final SeatPlaceRepository seatPlaceRepository;

    public SeatPlaceServiceImpl(SeatPlaceRepository seatPlaceRepository) {
        this.seatPlaceRepository = seatPlaceRepository;
    }

    @Override
    public void addSeatPlace(SeatPlace seatPlace) {
        seatPlaceRepository.save(seatPlace);
    }

    @Override
    public List<SeatPlace> getUnreservedSeatsByFlightId(Long id) {
        return seatPlaceRepository.getUnreservedSeatsByFlightId(id);
    }

    @Override
    public void setSeatToReserved(Long id) {
        seatPlaceRepository.changeSeatToReserved(id);
    }

    @Override
    public void setSeatToUnReserved(Long id) {
        seatPlaceRepository.changeSeatToUnReserved(id);
    }
}

