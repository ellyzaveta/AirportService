package com.airportService.frontend.components;

import com.airportService.backend.controllers.TicketController;
import com.airportService.backend.models.Ticket;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.Objects;

public class ReturnForm extends VerticalLayout {

    private final TicketController ticketController;

    private final TextField firstName = new TextField("First name");
    private final TextField lastName = new TextField("Last name");
    private final TextField ticketNumber = new TextField("Ticket number");
    private final TextField passportNumber = new TextField("Passport number");
    private final Button returnButton = new Button("Return Ticket");
    private final Button cancel = new Button("Cancel");
    private final HorizontalLayout buttons = new HorizontalLayout(returnButton, cancel);
    private final H2 heading = new H2("Return booked ticket");
    private final Notification ticketNotification = new Notification("no ticket with such number", 1500);
    private final Notification incorrectDataNotification = new Notification("incorrect passenger data", 1500);
    private final Notification success = new Notification("ticket returned successfully", 1500);

    public ReturnForm(TicketController ticketController) {
        this.ticketController = ticketController;
        returnButton.addClickListener(e -> save());
        cancel.addClickListener(e -> cancel());
        firstName.setWidth("100%");
        lastName.setWidth("100%");
        ticketNumber.setWidth("100%");
        passportNumber.setWidth("100%");
        add(heading, ticketNumber, firstName, lastName, passportNumber, buttons);
    }

    private void save() {
        Ticket ticket = ticketController.findByUniqueNumber(ticketNumber.getValue());
        if(ticket != null) {
            if(Objects.equals(ticket.getPassenger().getFirstName(), firstName.getValue()) &&
                    Objects.equals(ticket.getPassenger().getLastName(), lastName.getValue()) &&
                    Objects.equals(ticket.getPassenger().getPassportNumber(), passportNumber.getValue())) {
                ticketController.delete(ticket);
                firstName.clear();
                lastName.clear();
                passportNumber.clear();
                ticketNumber.clear();
                success.open();
            }
            else {
                incorrectDataNotification.open();
            }
        }
        else{
            ticketNotification.open();
        }
    }

    private void cancel() {
        firstName.clear();
        lastName.clear();
        passportNumber.clear();
        ticketNumber.clear();
    }

}

