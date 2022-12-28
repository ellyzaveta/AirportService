package com.airportService.backend.services;

import com.airportService.backend.models.Ticket;
import com.airportService.backend.modelsLight.TicketForm;
import com.airportService.backend.modelsLight.TicketLight;

import java.util.List;

public interface TicketService {
    TicketForm getTicketFormById(Long id);
    Ticket findByUniqueNumber(String number);
    void delete(Ticket ticket);
    void addTicket(Ticket ticket);
    Ticket findTicketById(Long id);
    List<Ticket> findAll();
    List<TicketLight> getTicketsLight();
    List<TicketLight> getTicketsLightOnFlight(String flightNumber);
    List<TicketLight> getTicketsLightOnPassport(String passport);
    List<TicketLight> getTicketsLightOnFlightAndPassport(String flight, String passport);
    void setHasBoardingPassToTrue(Long id);
}
