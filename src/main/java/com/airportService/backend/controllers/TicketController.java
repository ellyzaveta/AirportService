package com.airportService.backend.controllers;

import com.airportService.backend.models.PassportControl;
import com.airportService.backend.models.SecurityControl;
import com.airportService.backend.models.Ticket;
import com.airportService.backend.modelsLight.TicketForm;
import com.airportService.backend.modelsLight.TicketLight;
import com.airportService.backend.services.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {
    @Autowired
    private final TicketServiceImpl ticketService;
    @Autowired
    private final SeatPlaceController seatPlaceController;
    @Autowired
    private final FlightController flightController;
    @Autowired
    private final SecurityControlController securityControlController;
    @Autowired
    private final PassportControlController passportControlController;

    public TicketController(TicketServiceImpl ticketService, SeatPlaceController seatPlaceController, FlightController flightController, SecurityControlController securityControlController, PassportControlController passportControlController) {
        this.ticketService = ticketService;
        this.seatPlaceController = seatPlaceController;
        this.flightController = flightController;
        this.securityControlController = securityControlController;
        this.passportControlController = passportControlController;
    }

    public TicketForm getTicketFormById(Long id) {
        return ticketService.getTicketFormById(id);
    }

    public Ticket findByUniqueNumber(String number) {
        return ticketService.findByUniqueNumber(number);
    }

    public void delete(Ticket ticket) {
        ticketService.delete(ticket);
        List<SecurityControl> securityRecord = securityControlController.getRecordByPassport(ticket.getPassenger().getPassportNumber());
        for(SecurityControl record: securityRecord) {
            securityControlController.delete(record);
        }

        List<PassportControl> passportRecord = passportControlController.getRecordByPassport(ticket.getPassenger().getPassportNumber());
        for(PassportControl record: passportRecord) {
            passportControlController.delete(record);
        }

        seatPlaceController.setSeatToUnReserved(ticket.getSeatPlace().getId());
        flightController.changeNumOfTicketToPlusOne(ticket.getFlight().getId());
    }

    public void addTicket(Ticket ticket) {
        ticketService.addTicket(ticket);
    }

    public Ticket findTicketById(Long id) {
        return ticketService.findTicketById(id);
    }

    public List<Ticket> findAll() {
        return ticketService.findAll();
    }

    public List<TicketLight> getTicketsLight() {
        return ticketService.getTicketsLight();
    }

    public List<TicketLight> getTicketsLightOnFlight(String flightNumber) {
        return ticketService.getTicketsLightOnFlight(flightNumber);
    }

    public List<TicketLight> getTicketsLightOnPassport(String passport) {
        return ticketService.getTicketsLightOnPassport(passport);
    }

    public List<TicketLight> getTicketsLightOnFlightAndPassport(String flight, String passport) {
        return ticketService.getTicketsLightOnFlightAndPassport(flight, passport);
    }

    public void setHasBoardingPassToTrue(Long id) {
        ticketService.setHasBoardingPassToTrue(id);
    }

    public List<Ticket> findByPassengerID(Long id) {
        return ticketService.findByPassengerID(id);
    }
}
