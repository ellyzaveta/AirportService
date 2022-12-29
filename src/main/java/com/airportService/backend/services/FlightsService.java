package com.airportService.backend.services;

import com.airportService.backend.models.Flight;
import com.airportService.backend.modelsLight.*;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface FlightsService {
    public void addFlight(Flight flight);
    public Flight findFlightById(Long id);
    public List<Flight> findAllFlights();
    public void deleteFlight(Flight flight);
    List<Flight> getFlightReportBasedOnDestAirport(String destAirportName);
    List<Flight> getFlightReportBasedOnTimeInterval(Date lowBoundary, Date highBoundary);
    List<TimeWidget> getFlightsToDepartureLessThanIn2Hours();
    List<TicketWidget> getTicketWidget();
    List<TicketWidget> getTicketWidgetBasedOnAirport(String airportName);
    List<TimeWidget> getTimeWidget();
    public List<FlightFuel> getFuelReport();
    List<FlightLight> getFlightsOnDestAirport(String airportName);
    List<FlightLight> getFlightsLight();
    Flight findByFlightNumber(String flightNumber);
    void changeNumOfTicket(Long id);
    List<FlightTime> getTimeInterval(Date lowBoundary, Date highBoundary);
    List<FlightTime> getTimeInterval();
    void changeNumOfTicketToPlusOne(Long id);
    List<FlightFuel> getFuelReportBasedOnModel(String model);
}
