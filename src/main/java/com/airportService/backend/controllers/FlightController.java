package com.airportService.backend.controllers;

import com.airportService.backend.models.Flight;
import com.airportService.backend.modelsLight.*;
import com.airportService.backend.services.FlightsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {
    @Autowired
    private final FlightsServiceImpl flightsService;

    public FlightController(FlightsServiceImpl flightService) {
        this.flightsService = flightService;
    }

    public void addFlight(Flight flight) {
        flightsService.addFlight(flight);
    }

    public Flight findFlightById(Long id) {
        return flightsService.findFlightById(id);
    }

    public List<Flight> findAllFlights() {
        return flightsService.findAllFlights();
    }

    public void deleteFlight(Flight flight) {
        flightsService.deleteFlight(flight);
    }

    public List<Flight> getFlightReportBasedOnDestAirport(String destAirportName) {
        return flightsService.getFlightReportBasedOnDestAirport(destAirportName);
    }

    public List<Flight> getFlightReportBasedOnTimeInterval(Date lowBoundary, Date highBoundary) {
        return flightsService.getFlightReportBasedOnTimeInterval(lowBoundary, highBoundary);
    }

    public List<TimeWidget> getFlightsToDepartureLessThanIn2Hours() {
        return flightsService.getFlightsToDepartureLessThanIn2Hours();
    }

    public List<TicketWidget> getTicketWidget() {
        return flightsService.getTicketWidget();
    }

    public List<TicketWidget> getTicketWidgetBasedOnAirport(String airportName) {
        return flightsService.getTicketWidgetBasedOnAirport(airportName);
    }

    public List<TimeWidget> getTimeWidget() {
        return flightsService.getTimeWidget();
    }

    public List<FlightFuel> getFuelReport() {
        return flightsService.getFuelReport();
    }

    public List<FlightLight> getFlightsOnDestAirport(String airportName) {
        return flightsService.getFlightsOnDestAirport(airportName);
    }

    public List<FlightLight> getFlightsLight() {
        return flightsService.getFlightsLight();
    }

    public Flight findByFlightNumber(String flightNumber) {
        return flightsService.findByFlightNumber(flightNumber);
    }

    public void changeNumOfTicket(Long id) {
        flightsService.changeNumOfTicket(id);
    }

    public List<FlightTime> getTimeInterval(Date lowBoundary, Date highBoundary) {
        return flightsService.getTimeInterval(lowBoundary, highBoundary);
    }

    public List<FlightTime> getTimeInterval() {
        return flightsService.getTimeInterval();
    }

    public void changeNumOfTicketToPlusOne(Long id) {
        flightsService.changeNumOfTicketToPlusOne(id);
    }

    public List<FlightFuel> getFuelReportBasedOnModel(String model) {
        return flightsService.getFuelReportBasedOnModel(model);
    }
}

