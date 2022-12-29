package com.airportService.frontend.components;

import com.airportService.backend.controllers.BoardingPassController;
import com.airportService.backend.controllers.LuggageController;
import com.airportService.backend.controllers.LuggageTypeController;
import com.airportService.backend.controllers.TicketController;
import com.airportService.backend.models.BoardingPass;
import com.airportService.backend.models.Luggage;
import com.airportService.backend.models.LuggageType;
import com.airportService.backend.models.Ticket;
import com.airportService.backend.modelsLight.TicketLight;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardingPassForm extends VerticalLayout {
    @Autowired
    private final BoardingPassController boardingPassController;
    @Autowired
    private final LuggageTypeController luggageTypeController;
    @Autowired
    private final TicketController ticketControllerController;
    @Autowired
    private final LuggageController luggageController;
    private final Ticket ticket;
    private final TextField luggageWeight = new TextField("Luggage weight");
    private final Label firstName;
    private final Label lastName;
    private final Label passportNumber;
    private final ComboBox<LuggageType> comboBox = new ComboBox<>("Luggage type");
    private final H2 heading = new H2("Boarding pass creation");
    private final HorizontalLayout luggageAttributes = new HorizontalLayout(luggageWeight, comboBox);
    private final Image image = new Image("images/return-tickets.png", "img");
    private final VerticalLayout form = new VerticalLayout();
    private final Button save = new Button("Save");
    private final Button cancel = new Button("Cancel");
    private final HorizontalLayout toolbar = new HorizontalLayout();
    private final Button cont = new Button("Get");
    private final HorizontalLayout main = new HorizontalLayout();
    private final Notification errorNotification = new Notification("Entered data is incorrect!", 1500);


    public BoardingPassForm(BoardingPassController boardingPassController, LuggageTypeController luggageTypeController,
                            TicketController ticketControllerController, LuggageController luggageController, TicketLight ticketLight) {
        this.boardingPassController = boardingPassController;
        this.luggageTypeController = luggageTypeController;
        this.ticketControllerController = ticketControllerController;
        this.luggageController = luggageController;
        this.ticket = ticketControllerController.findByUniqueNumber(ticketLight.getTicketNumber());

        firstName = new Label("First name:\t\t" + ticket.getPassenger().getFirstName());
        lastName = new Label("Last name:\t\t" + ticket.getPassenger().getLastName());
        passportNumber = new Label("Passport number: " + ticket.getPassenger().getPassportNumber());
        comboBox.setItems(luggageTypeController.findAll());
        comboBox.setItemLabelGenerator(LuggageType::getLuggageType);
        luggageAttributes.setPadding(false);

        cont.addClickListener(e -> setVisible(false));
        save.addClickListener(e -> save());
        cancel.addClickListener(e -> setVisible(false));
        cancel.setWidth("100%");
        toolbar.add(save, cancel);

        form.add(heading, firstName, lastName, passportNumber, luggageAttributes, toolbar);

        image.setWidth("550px");

        this.getElement().getStyle()
                .set("box-shadow", "4px 0px 10px rgba(0, 0, 0, 0.2)")
                .set("background", "white")
                .set("padding", "10px 20px");

        main.setWidth("100%");
        main.add(form, image);

        add(main);
    }

    public void save() {
        try
        {
            BoardingPass boardingPass = new BoardingPass();
            boardingPass.setTicket(ticket);
            Luggage luggage = new Luggage();
            luggage.setWeight(Double.parseDouble(luggageWeight.getValue()));
            luggage.setLuggageType(comboBox.getValue());
            luggageController.addLuggage(luggage);
            boardingPass.setLuggage(luggage);
            boardingPassController.addBoardingPass(boardingPass);
            BoardingPassList boardingPassList = new BoardingPassList(boardingPassController.getBoardingPassForm(boardingPass.getId()));
            remove(main);
            boardingPassList.setWidth("100%");
            add(boardingPassList, cont);
        }
        catch(NumberFormatException e)
        {
            errorNotification.open();
        }

    }
}
