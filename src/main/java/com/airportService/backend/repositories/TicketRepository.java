package com.airportService.backend.repositories;

import com.airportService.backend.models.Ticket;
import com.airportService.backend.modelsLight.TicketForm;
import com.airportService.backend.modelsLight.TicketLight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("select new com.airportService.backend.modelsLight.TicketForm(t.passenger.firstName, t.passenger.lastName, t.flight.flightNumber, t.flight.departureTime," +
            "t.flight.arrAirport, t.seatPlace.seatNumber, t.buyingDate, t.flight.price, t.uniqueNumber) from Ticket t where t.id =:id")
    TicketForm getTicketFormById(@Param("id") Long id);

    Ticket findByUniqueNumber(String number);

    @Query("select new com.airportService.backend.modelsLight.TicketLight(t.flight.flightNumber, t.passenger.passportNumber," +
            "t.seatPlace.seatNumber, t.uniqueNumber) from Ticket t where t.hasBoardingPass = false")
    List<TicketLight> getTicketsLight();

    @Query("select new com.airportService.backend.modelsLight.TicketLight(t.flight.flightNumber, t.passenger.passportNumber," +
            "t.seatPlace.seatNumber, t.uniqueNumber) from Ticket t where t.hasBoardingPass = false and t.flight.flightNumber =:flight")
    List<TicketLight> getTicketsLightOnFlight(@Param("flight") String flightNumber);

    @Query("select new com.airportService.backend.modelsLight.TicketLight(t.flight.flightNumber, t.passenger.passportNumber," +
            "t.seatPlace.seatNumber, t.uniqueNumber) from Ticket t where t.hasBoardingPass = false and t.passenger.passportNumber =:passport")
    List<TicketLight> getTicketsLightOnPassport(@Param("passport") String passport);

    @Query("select new com.airportService.backend.modelsLight.TicketLight(t.flight.flightNumber, t.passenger.passportNumber," +
            "t.seatPlace.seatNumber, t.uniqueNumber) from Ticket t where t.hasBoardingPass = false and t.passenger.passportNumber =:passport and t.flight.flightNumber =:flight")
    List<TicketLight> getTicketsLightOnFlightAndPassport(@Param("flight") String flight, @Param("passport") String passport);

    @Query("select t from Ticket t where t.passenger.id =:id")
    List<Ticket> findByPassengerID(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Ticket t set t.hasBoardingPass = true where t.id = :id")
    void setHasBoardingPassToTrue(@Param("id") Long id);
}
