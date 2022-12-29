package com.airportService.frontend.components;

import com.airportService.backend.modelsLight.BoardingPassForm;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BoardingPassList extends HorizontalLayout {
    private final Label firstName;
    private final Label lastName;
    private final Label flightNumber;
    private final Label depTime;
    private final Label seat;
    private final Label arrivalAirport;
    private final Label qrCode;
    private final VerticalLayout form = new VerticalLayout();
    private final Image qr = new Image("images/qr.png", "gr");

    public BoardingPassList(BoardingPassForm boardingPassForm) {
        firstName = new Label("First name: " + boardingPassForm.getFirstName());
        lastName = new Label("Last name: " + boardingPassForm.getLastName());
        flightNumber = new Label("Flight number: " + boardingPassForm.getFlightNumber());
        depTime = new Label("Departure time: " + boardingPassForm.getDepTime());
        seat = new Label("Seat number: " + boardingPassForm.getSeat());
        arrivalAirport = new Label("Arrival airport: " + boardingPassForm.getArrAirport());
        qrCode = new Label("QR code: " + boardingPassForm.getQrCode());
        form.add(firstName, lastName, flightNumber, depTime, seat, arrivalAirport, qrCode);
        form.getElement().getStyle().set("padding-top", "20px");
        qr.setWidth("300px");
        this.getElement().getStyle().set("border", "2px solid #E8EBEE");
        add(form, qr);
    }
}

