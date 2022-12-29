package com.airportService.frontend.grids;

import com.airportService.backend.controllers.BoardingPassController;
import com.airportService.backend.controllers.LuggageController;
import com.airportService.backend.controllers.LuggageTypeController;
import com.airportService.backend.controllers.TicketController;
import com.airportService.backend.modelsLight.TicketLight;
import com.airportService.frontend.components.BoardingPassForm;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "tickets")
@PageTitle("Tickets")
public class TicketGrid extends VerticalLayout {
    @Autowired
    private final TicketController ticketController;
    @Autowired
    private final BoardingPassController boardingPassController;
    @Autowired
    private final LuggageTypeController luggageTypeController;
    @Autowired
    private final LuggageController luggageController;

    private Grid<TicketLight> grid = new Grid<>(TicketLight.class);
    private final TextField flightFilter = new TextField();
    private final TextField passportFilter = new TextField();
    private final HorizontalLayout toolbar = new HorizontalLayout(flightFilter, passportFilter);
    H1 text = new H1("Passenger check-in");

    @Autowired
    public TicketGrid(TicketController ticketController, BoardingPassController boardingPassController, LuggageTypeController luggageTypeController, LuggageController luggageController) {
        this.ticketController = ticketController;
        this.boardingPassController = boardingPassController;
        this.luggageTypeController = luggageTypeController;
        this.luggageController = luggageController;
        flightFilter.setPlaceholder("Flight number");
        flightFilter.setValueChangeMode(ValueChangeMode.EAGER);
        flightFilter.addValueChangeListener(field -> fillList(field.getValue(), passportFilter.getValue()));
        passportFilter.setPlaceholder("Passport number");
        passportFilter.setValueChangeMode(ValueChangeMode.EAGER);
        passportFilter.addValueChangeListener(field -> fillList(flightFilter.getValue(), field.getValue()));
        add(text, toolbar, grid);

        grid.addComponentColumn(e -> {
            Button button = new Button("Create boarding pass");
            button.addClickListener(event -> add(new BoardingPassForm(boardingPassController, luggageTypeController, ticketController, luggageController, e)));
            return button;
        });
        grid.getElement().getStyle().set("box-shadow", "0px 4px 20px rgba(0, 0, 0, 0.25)");
        text.getElement().getStyle().set("margin-top", "0");
        fillList("", "");
    }

    private void fillList(String flightNumber, String passport) {
        if (flightNumber.isEmpty() && passport.isEmpty()) {
            grid.setItems(this.ticketController.getTicketsLight());
        } else if (passport.isEmpty()) {
            grid.setItems(this.ticketController.getTicketsLightOnFlight(flightNumber));
        } else if (flightNumber.isEmpty()) {
            grid.setItems(this.ticketController.getTicketsLightOnPassport(passport));
        } else {
            grid.setItems(this.ticketController.getTicketsLightOnFlightAndPassport(flightNumber, passport));
        }
    }
}
