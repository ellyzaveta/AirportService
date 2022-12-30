package com.airportService.backend.repositories;

import com.airportService.backend.models.Flight;
import com.airportService.backend.modelsLight.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("select f from Flight f where f.arrAirport = :airport")
    List<Flight> getFlightsBasedOnDestAirport(@Param("airport") String airportName);

    @Query("select new com.airportService.backend.modelsLight.FlightLight(f.flightNumber, f.departureTime, " +
            "f.arrivalTime, f.depAirport, f.arrAirport, f.price) from Flight f where f.arrAirport = :airport and f.numOfAvailablePlaces > 0")
    List<FlightLight> getFlightsOnDestAirport(@Param("airport") String airportName);

    @Query("select new com.airportService.backend.modelsLight.FlightLight(f.flightNumber, f.departureTime, " +
            "f.arrivalTime, f.depAirport, f.arrAirport, f.price) from Flight f where f.numOfAvailablePlaces > 0")
    List<FlightLight> getFlightsLight();

    @Query("select new com.airportService.backend.modelsLight.FlightFuel(f.flightNumber, f.aircraft.model, f.totalTime, f.aircraft.fuelPerHour) from Flight f")
    List<FlightFuel> getFuelReport();

    @Query("select new com.airportService.backend.modelsLight.FlightFuel(f.flightNumber, f.aircraft.model, f.totalTime, f.aircraft.fuelPerHour) from Flight f where f.aircraft.model=:model")
    List<FlightFuel> getFuelReportBasedOnModel(@Param("model") String model);

    @Query(value = "SELECT f FROM Flight f WHERE f.departureTime >= :low and f.departureTime <= :high")
    List<Flight> getFlightReportBasedOnTimeInterval(@Param("low") Date lowBoundary, @Param("high")Date highBoundary);

    @Query(value = "select new com.airportService.backend.modelsLight.FlightTime(f.flightNumber, f.departureTime, " +
            "f.arrivalTime, f.depAirport, f.arrAirport, f.numOfAvailablePlaces) from Flight f where f.departureTime >= :low and f.departureTime <= :high")
    List<FlightTime> getTimeInterval(@Param("low")Date lowBoundary, @Param("high")Date highBoundary);

    @Query(value = "select new com.airportService.backend.modelsLight.FlightTime(f.flightNumber, f.departureTime, " +
            "f.arrivalTime, f.depAirport, f.arrAirport, f.numOfAvailablePlaces) from Flight f")
    List<FlightTime> getTimeInterval();

    @Query(value = "select new com.airportService.backend.modelsLight.TimeWidget(f.flightNumber, f.arrAirport, f.departureTime) FROM Flight f WHERE f.departureTime >= :low and f.departureTime <= :high")
    List<TimeWidget> getFlightWidgetBasedOnTimeInterval(@Param("low")Date lowBoundary, @Param("high")Date highBoundary);

    @Query("select new com.airportService.backend.modelsLight.TicketWidget(f.flightNumber, f.depAirport, f.arrAirport, f.numOfAvailablePlaces) from Flight f")
    List<TicketWidget> getTicketWidget();

    @Query("select new com.airportService.backend.modelsLight.TicketWidget(f.flightNumber, f.depAirport, f.arrAirport, f.numOfAvailablePlaces) from Flight f where f.arrAirport =:airport")
    List<TicketWidget> getTicketWidgetBasedOnAirport(@Param("airport") String airportName);

    @Query("select new com.airportService.backend.modelsLight.TimeWidget(f.flightNumber, f.arrAirport, f.departureTime) from Flight f")
    List<TimeWidget> getTimeWidget();

    Flight findByFlightNumber(String flightNumber);

    @Modifying
    @Transactional
    @Query("update Flight f set f.numOfAvailablePlaces = f.numOfAvailablePlaces - 1 where f.id = :id")
    void changeNumOfTicket(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query("update Flight f set f.numOfAvailablePlaces = f.numOfAvailablePlaces + 1 where f.id = :id")
    void changeNumOfTicketToPlusOne(@Param("id") Long id);
}
