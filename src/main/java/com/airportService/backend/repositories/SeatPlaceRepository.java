package com.airportService.backend.repositories;

import com.airportService.backend.models.SeatPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface SeatPlaceRepository extends JpaRepository<SeatPlace, Long> {
    @Query("select s from SeatPlace s where s.flight.id =:id and s.isReserved = false")
    List<SeatPlace> getUnreservedSeatsByFlightId(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update SeatPlace s set s.isReserved = true where s.id = :id")
    void changeSeatToReserved(Long id);

    @Modifying
    @Transactional
    @Query("update SeatPlace s set s.isReserved = false where s.id = :id")
    void changeSeatToUnReserved(Long id);
}
