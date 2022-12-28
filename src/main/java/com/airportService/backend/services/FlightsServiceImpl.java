package com.airportService.backend.services;

import com.airportService.backend.models.Flight;
import com.airportService.backend.modelsLight.*;
import com.airportService.backend.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class FlightsServiceImpl implements FlightsService{
    @Autowired
    private final FlightRepository flightRepository;

    public FlightsServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void addFlight(Flight flight) {
        flight.setTotalTime(TimeUnit.MILLISECONDS.toHours(flight.getArrivalTime().getTime() - flight.getDepartureTime().getTime()));
        flightRepository.save(flight);
    }

    @Override
    public Flight findFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    @Override
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public void deleteFlight(Flight flight) {
        flightRepository.delete(flight);
    }

    @Override
    public List<Flight> getFlightReportBasedOnDestAirport(String destAirportName) {
        return flightRepository.getFlightsBasedOnDestAirport(destAirportName);
    }

    @Override
    public List<Flight> getFlightReportBasedOnTimeInterval(Date lowBoundary, Date highBoundary) {
        return flightRepository.getFlightReportBasedOnTimeInterval(lowBoundary, highBoundary);
    }

    @Override
    public List<TimeWidget> getFlightsToDepartureLessThanIn2Hours() {
        Date low = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(low);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        Date high = calendar.getTime();
        return flightRepository.getFlightWidgetBasedOnTimeInterval(low, high);
    }

    @Override
    public List<TicketWidget> getTicketWidget() {
        return flightRepository.getTicketWidget();
    }

    @Override
    public List<TicketWidget> getTicketWidgetBasedOnAirport(String airportName) {
        return flightRepository.getTicketWidgetBasedOnAirport(airportName);
    }

    @Override
    public List<TimeWidget> getTimeWidget() {
        return flightRepository.getTimeWidget();
    }

    @Override
    public List<FlightFuel> getFuelReport() {
        return flightRepository.getFuelReport();
    }

    @Override
    public List<FlightLight> getFlightsOnDestAirport(String airportName) {
        return flightRepository.getFlightsOnDestAirport(airportName);
    }

    @Override
    public List<FlightLight> getFlightsLight() {
        return flightRepository.getFlightsLight();
    }

    @Override
    public Flight findByFlightNumber(String flightNumber) {
        return flightRepository.findByFlightNumber(flightNumber);
    }

    @Override
    public void changeNumOfTicket(Long id) {
        flightRepository.changeNumOfTicket(id);
    }

    @Override
    public List<FlightTime> getTimeInterval(Date lowBoundary, Date highBoundary) {
        return flightRepository.getTimeInterval(lowBoundary, highBoundary);
    }

    @Override
    public List<FlightTime> getTimeInterval() {
        return flightRepository.getTimeInterval();
    }

    @Override
    public void changeNumOfTicketToPlusOne(Long id) {
        flightRepository.changeNumOfTicketToPlusOne(id);
    }
}
