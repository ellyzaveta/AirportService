package com.airportService.backend.services;

import com.airportService.backend.models.Ticket;
import com.airportService.backend.modelsLight.TicketForm;
import com.airportService.backend.modelsLight.TicketLight;
import com.airportService.backend.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public TicketForm getTicketFormById(Long id) {
        return ticketRepository.getTicketFormById(id);
    }

    @Override
    public Ticket findByUniqueNumber(String number) {
        return ticketRepository.findByUniqueNumber(number);
    }

    @Override
    public void delete(Ticket ticket) {
        ticketRepository.delete(ticket);
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public Ticket findTicketById(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public List<TicketLight> getTicketsLight() {
        return ticketRepository.getTicketsLight();
    }

    @Override
    public List<TicketLight> getTicketsLightOnFlight(String flightNumber) {
        return ticketRepository.getTicketsLightOnFlight(flightNumber);
    }

    @Override
    public List<TicketLight> getTicketsLightOnPassport(String passport) {
        return ticketRepository.getTicketsLightOnPassport(passport);
    }

    @Override
    public List<TicketLight> getTicketsLightOnFlightAndPassport(String flight, String passport) {
        return ticketRepository.getTicketsLightOnFlightAndPassport(flight, passport);
    }

    @Override
    public void setHasBoardingPassToTrue(Long id) {
        ticketRepository.setHasBoardingPassToTrue(id);
    }
}

