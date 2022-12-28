package com.airportService.backend.controllers;

import com.airportService.backend.models.*;
import com.airportService.backend.modelsLight.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;

@Controller
public class MainFlightController {
    @Autowired
    private final FlightController flightController;
    @Autowired
    private final TicketController ticketController;
    @Autowired
    private final PassengerController passengerController;
    @Autowired
    private final SeatController seatController;
    @Autowired
    private final SeatPlaceController seatPlaceController;
    @Autowired
    private final AircraftController aircraftController;

    public MainFlightController(FlightController flightController, TicketController ticketController, PassengerController passengerController, SeatController seatController, SeatPlaceController seatPlaceController, AircraftController aircraftController) {
        this.flightController = flightController;
        this.ticketController = ticketController;
        this.passengerController = passengerController;
        this.seatController = seatController;
        this.seatPlaceController = seatPlaceController;
        this.aircraftController = aircraftController;
    }

    public void addPassenger(Passenger passenger) {
        passengerController.addPassenger(passenger);
    }

    public Passenger findPassengerById(Long id) {
        return passengerController.findById(id);
    }

    public List<Passenger> findAllPassengers(){
        return passengerController.findAll();
    }

    public void delete(Passenger passenger) {
        passengerController.delete(passenger);
    }

    public void addFlight(Flight flight) {
        flight.setNumOfAvailablePlaces(flight.getAircraft().getTotalNumOfPlaces());
        flightController.addFlight(flight);
    }

    public Flight findById(Long id) {
        return flightController.findFlightById(id);
    }

    public List<Flight> findAll() {
        return flightController.findAllFlights();
    }

    public void delete(Flight flight) {
        flightController.deleteFlight(flight);
    }

    public List<Flight> getFlightReportBasedOnDestAirport(String destAirportName) {
        return flightController.getFlightReportBasedOnDestAirport(destAirportName);
    }

    public List<Flight> getFlightReportBasedOnTimeInterval(Date lowBoundary, Date highBoundary) {
        return flightController.getFlightReportBasedOnTimeInterval(lowBoundary, highBoundary);
    }

    public List<TicketWidget> getTicketWidget() {
        return flightController.getTicketWidget();
    }

    public List<TimeWidget> getFlightsToDepartureLessThanIn2Hours() {
        return flightController.getFlightsToDepartureLessThanIn2Hours();
    }

    public List<FlightFuel> getFuelReport() {
        return flightController.getFuelReport();
    }

    public TicketForm getTicketFormById(Long id) {
        return ticketController.getTicketFormById(id);
    }

    public void addTicket(Ticket ticket) {
        ticketController.addTicket(ticket);
        seatPlaceController.setSeatToReserved(ticket.getSeatPlace().getId());
        flightController.changeNumOfTicket(ticket.getFlight().getId());
    }

    public Ticket findTicketById(Long id) {
        return ticketController.findTicketById(id);
    }

    public void addAircraft(Aircraft aircraft) {
        aircraftController.addAircraft(aircraft);
    }

    public Aircraft findAircraftById(Long id) {
        return aircraftController.findAircraftById(id);
    }

    public List<Seat> findAllSeats() {
        return seatController.findAll();
    }

    public void addSeat(Seat seat) {
        seatController.addSeat(seat);
    }

    public void addSeatPlace(SeatPlace seatPlace) {
        seatPlaceController.addSeatPlace(seatPlace);
    }

    public List<SeatPlace> getUnreservedSeatsByFlightId(Long id) {
        return seatPlaceController.getUnreservedSeatsByFlightId(id);
    }

    public void changeSeatToReserved(Long id) {
        seatPlaceController.setSeatToReserved(id);
    }

    public List<TicketWidget> getTicketWidgetBasedOnAirport(String airportName) {
        return flightController.getTicketWidgetBasedOnAirport(airportName);
    }

    public List<FlightLight> getFlightsOnDestAirport(String airportName) {
        return flightController.getFlightsOnDestAirport(airportName);
    }

    public List<FlightLight> getFlightsLight() {
        return flightController.getFlightsLight();
    }

    public Flight findByFlightNumber(String flightNumber) {
        return flightController.findByFlightNumber(flightNumber);
    }

    public Passenger findByPassportNumber(String passportNumber) {
        return passengerController.findByPassportNumber(passportNumber);
    }
}
