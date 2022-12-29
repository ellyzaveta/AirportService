package com.airportService.backend.repositories;

import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.modelsLight.BoardingPassForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BoardingPassRepository extends JpaRepository<BoardingPass, Long> {
    @Query("select new com.airportService.backend.modelsLight.BoardingPassForm(b.ticket.passenger.firstName, b.ticket.passenger.lastName," +
            "b.ticket.flight.flightNumber, b.ticket.flight.departureTime," +
            "b.ticket.seatPlace.seatNumber, b.ticket.flight.arrAirport, b.qrCode) from BoardingPass b where b.id =:id")
    BoardingPassForm getBoardingPassForm(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update BoardingPass b set b.isChecked = true where b.id = :id")
    void setIsCheckedToTrue(@Param("id") Long id);
}

