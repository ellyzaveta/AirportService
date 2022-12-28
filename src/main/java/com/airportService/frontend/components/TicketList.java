package com.airportService.frontend.components;

import com.airportService.backend.modelsLight.TicketForm;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TicketList extends VerticalLayout {
    private final Label firstName;
    private final Label lastName;
    private final Label flightNumber;
    private final Label depTime;
    private final Label arrAirport;
    private final Label seat;
    private final Label buyingDate;
    private final Label price;
    private final H3 ticketNumber;
    private final HorizontalLayout horizontalLayout = new HorizontalLayout();
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image image = new Image("images/ticket.png", "qr");

    public TicketList(TicketForm ticketForm) {
        this.getElement().getStyle().set("background", "white");
        this.getElement().getStyle().set("border", "2px solid #E8EBEE");
        ticketNumber = new H3("TICKET #" + ticketForm.getTicketNumber());
        firstName = new Label("First name:          " + ticketForm.getFirstName());
        lastName = new Label("Last name:          " + ticketForm.getLastName());
        flightNumber = new Label("Flight number:     " + ticketForm.getFlightNumber());
        depTime = new Label("Departure time:   " + ticketForm.getDepTime());
        arrAirport = new Label("Arrival airport:     " + ticketForm.getArrAirport());
        seat = new Label("Seat number:       " + ticketForm.getSeat());
        buyingDate = new Label("Buying date:         " + ticketForm.getBuyingDate().toString());
        price = new Label("Price:                     " + ticketForm.getPrice().toString());
        image.setWidth("550px");
        verticalLayout.setWidth("600px");
        verticalLayout.add(ticketNumber, firstName, lastName, flightNumber, depTime, arrAirport, seat, buyingDate, price);
        horizontalLayout.add(verticalLayout, image);
        add(horizontalLayout);
    }
}

