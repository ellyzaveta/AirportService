package com.airportService.frontend.components;

import com.airportService.backend.controllers.MainFlightController;
import com.airportService.backend.models.Flight;
import com.airportService.backend.models.Passenger;
import com.airportService.backend.models.SeatPlace;
import com.airportService.backend.models.Ticket;
import com.airportService.backend.modelsLight.FlightLight;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@UIScope
public class TicketForm extends VerticalLayout implements KeyNotifier {
    @Autowired
    private final MainFlightController mainFlightController;

    private Flight flight;
    private final TextField firstName = new TextField("", "First name");
    private final TextField lastName = new TextField("", "Last name");
    private final TextField passportNumber = new TextField("", "Passport Number");
    private final DatePicker birthDate = new DatePicker("birth Date");
    private final TextField countryOfCitizenship = new TextField("", "Country Of Citizenship");
    private final TextField countryOfResidents = new TextField("", "Country Of Residents");
    private final Button save = new Button("Save");
    private final Button cancel = new Button("Cancel");
    private final HorizontalLayout buttons = new HorizontalLayout(save, cancel);
    private final Button cont = new Button("Get");
    private final ComboBox<SeatPlace> comboBox = new ComboBox<>("Seat");
    private final VerticalLayout verticalLayout = new VerticalLayout();
    private final Image image = new Image("images/queue.png", "img");
    private final HorizontalLayout main = new HorizontalLayout();
    private final Notification errorNotification = new Notification("Entered data is incorrect!", 1500);

    public TicketForm(MainFlightController mainFlightController, FlightLight flightLight) {
        this.mainFlightController = mainFlightController;
        String fn = flightLight.getFlightNumber();
        flight = mainFlightController.findByFlightNumber(fn);
        init(flight);
        setSpacing(true);

        save.addClickListener(e -> save());

        cancel.addClickListener(e -> setVisible(false));
        cont.addClickListener(e -> setVisible(false));

        VerticalLayout verticalLayout1 = new VerticalLayout();
        VerticalLayout verticalLayout2 = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        verticalLayout1.setWidth("100%");
        verticalLayout2.setWidth("100%");
        verticalLayout1.add(firstName, lastName, passportNumber, comboBox);
        verticalLayout2.add(countryOfCitizenship, countryOfResidents, birthDate);
        verticalLayout1.setPadding(false);
        verticalLayout2.setPadding(false);
        horizontalLayout.add(verticalLayout1, verticalLayout2);
        birthDate.getElement().getStyle().set("margin-top", "0");
        passportNumber.getElement().getStyle().set("margin-top", "33px");
        image.setWidth("700px");
        String text = flight.getDepAirport() + " → " + flight.getArrAirport() + "    №" + flight.getFlightNumber();
        H2 heading = new H2(text);
        verticalLayout.add(heading, horizontalLayout, buttons);
        verticalLayout.getElement().getStyle().set("margin-left", "80px");
        this.getElement().getStyle()
                .set("background", "rgba(249, 252, 254, 1)")
                .set("box-shadow", "0px 4px 30px rgba(0, 0, 0, 0.25)");
        main.add(verticalLayout, image);
        add(main);
    }

    private void save() {
        if(!Objects.equals(firstName.getValue(), null) && !Objects.equals(lastName.getValue(), null) && !Objects.equals(birthDate.getValue(), null) &&
                !Objects.equals(passportNumber.getValue(), null) && !Objects.equals(countryOfResidents.getValue(), null) && !Objects.equals(countryOfCitizenship.getValue(), null) &&
                !Objects.equals(comboBox.getValue(), null)) {
            Passenger passenger1 = new Passenger();
            passenger1.setFirstName(firstName.getValue());
            passenger1.setLastName(lastName.getValue());
            passenger1.setBirthDate(birthDate.getValue());
            passenger1.setPassportNumber(passportNumber.getValue());
            passenger1.setCountryOfResidents(countryOfResidents.getValue());
            passenger1.setCountryOfCitizenship(countryOfCitizenship.getValue());
            Passenger passenger2 = mainFlightController.findByPassportNumber(passenger1.getPassportNumber());
            if (passenger2 == null) {
                mainFlightController.addPassenger(passenger1);
            } else {
                passenger1 = passenger2;
            }
            SeatPlace seat1 = comboBox.getValue();
            Ticket ticket = new Ticket();
            ticket.setPassenger(passenger1);
            ticket.setFlight(flight);
            ticket.setSeatPlace(seat1);
            mainFlightController.addTicket(ticket);
            TicketList ticketList = new TicketList(mainFlightController.getTicketFormById(ticket.getId()));
            remove(main);
            ticketList.setWidth("100%");

            add(ticketList, cont);
        }else {
            errorNotification.open();
        }
    }

    public void init(Flight flight) {
        this.flight = flight;
        if(flight != null) {
            comboBox.setItems(mainFlightController.getUnreservedSeatsByFlightId(flight.getId()));
            comboBox.setItemLabelGenerator(SeatPlace::getSeatNumber);
        }
    }


}